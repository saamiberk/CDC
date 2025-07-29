package com.hititcs;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.enterprise.jet.cdc.CdcSinks;
import com.hazelcast.jet.Job;
import com.hazelcast.jet.config.JobConfig;
import com.hazelcast.jet.core.JobStatus;
import com.hazelcast.jet.pipeline.*;
import com.hititcs.jet.cdc.batch.FlightSegmentBatchSourceFactory;
import com.hititcs.jet.cdc.batch.InventoryBatchSourceFactory;
import com.hititcs.jet.cdc.config.CacheConstants;
import com.hititcs.jet.cdc.config.CdcConfig;
import com.hititcs.jet.cdc.config.source.DebeziumSourceFactory;
import com.hititcs.jet.cdc.mapper.record.key.FlightSegmentKeyMapper;
import com.hititcs.jet.cdc.mapper.record.key.InventoryKeyMapper;
import com.hititcs.jet.cdc.mapper.record.value.FlightSegmentValueMapper;
import com.hititcs.jet.cdc.mapper.record.value.InventoryValueMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DebeziumStarter {

    public static HazelcastInstance hz = Hazelcast.bootstrappedInstance();
    //public static HazelcastInstance hz = HazelcastClient.newHazelcastClient();
    private static final Logger logger = LoggerFactory.getLogger(DebeziumStarter.class);

    public static void main(String[] args) {
        try {
            stopAllJobs();
            startAllPipelines();
        } catch (Exception e) {
            logger.error("Unexpected error", e);
        }
    }

    private static void startAllPipelines() {
        CdcConfig.load();

        startBatchJob("flt-segment-batch", FlightSegmentBatchSourceFactory.createPipeline());
        startBatchJob("inventory-batch", InventoryBatchSourceFactory.createPipeline());

        startCdcJob("cdc-flt-segment", createFlightSegmentCdcPipeline());
        startCdcJob("cdc-inventory", createInventoryCdcPipeline());
    }

    private static void startBatchJob(String jobName, Pipeline pipeline) {
        logger.info("Starting {} job...", jobName);
        hz.getJet().newJob(pipeline, new JobConfig().setName(jobName)).join();
        logger.info("Finished {} job.", jobName);
    }

    private static void startCdcJob(String jobName, Pipeline pipeline) {
        logger.info("Starting CDC job: {}", jobName);
        hz.getJet().newJobIfAbsent(pipeline, new JobConfig().setName(jobName));
    }

    private static Pipeline createFlightSegmentCdcPipeline() {
        Pipeline pipeline = Pipeline.create();
        pipeline
                .readFrom(DebeziumSourceFactory.getDebeziumSource())
                .withoutTimestamps()
                .setLocalParallelism(1)
                .filter(r -> "FLT_SEGMENT".equalsIgnoreCase(r.table()))
                .writeTo(CdcSinks.map(CacheConstants.CACHE_NAME_FLT_SEGMENT,
                        new FlightSegmentKeyMapper(), new FlightSegmentValueMapper()));
        return pipeline;
    }

    private static Pipeline createInventoryCdcPipeline() {
        Pipeline pipeline = Pipeline.create();
        pipeline
                .readFrom(DebeziumSourceFactory.getDebeziumSource())
                .withoutTimestamps()
                .setLocalParallelism(1)
                .filter(r -> "INVENTORY".equalsIgnoreCase(r.table()))
                .writeTo(CdcSinks.map(CacheConstants.CACHE_NAME_INVENTORY,
                        new InventoryKeyMapper(), new InventoryValueMapper()));
        return pipeline;
    }

    private static void stopAllJobs() {
        for (Job job : hz.getJet().getJobs()) {
            if (job.getName() != null && (
                    job.getName().contains("batch") ||
                            job.getName().startsWith("cdc-"))) {
                if (job.getStatus() == JobStatus.RUNNING) {
                    logger.info("Cancelling job: {}", job.getName());
                    job.cancel();
                    job.join();
                }
            }
        }
    }
}