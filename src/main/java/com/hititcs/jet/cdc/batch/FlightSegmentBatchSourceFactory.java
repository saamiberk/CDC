package com.hititcs.jet.cdc.batch;

import com.hazelcast.jet.pipeline.BatchSource;
import com.hazelcast.jet.pipeline.Pipeline;
import com.hazelcast.jet.pipeline.Sinks;
import com.hazelcast.jet.pipeline.Sources;
import com.hititcs.jet.cdc.config.CacheConstants;
import com.hititcs.jet.cdc.config.CdcConfig;
import com.hititcs.jet.cdc.mapper.resultset.FlightSegmentResultSetMapper;
import com.hititcs.jet.cdc.record.FlightSegment;


public class FlightSegmentBatchSourceFactory {

    public static Pipeline createPipeline() {
        Pipeline fltSegmentBatch = Pipeline.create();
        fltSegmentBatch.readFrom(create())
                .writeTo(Sinks.map(CacheConstants.CACHE_NAME_FLT_SEGMENT,
                        FlightSegment::getSegIsn,
                        fs -> fs))
                .setLocalParallelism(Runtime.getRuntime().availableProcessors());
        return fltSegmentBatch;

    }

    public static BatchSource<FlightSegment> create() {
        return Sources.jdbc(CdcConfig.getConnectionString(),
                "SELECT *\n" +
                        "FROM FLT_SEGMENT\n" +
                        "WHERE SCH_DEP_DT >= TRUNC(SYSDATE)\n" +
                        "  AND SCH_DEP_DT <= TRUNC(ADD_MONTHS(SYSDATE, 12))",
                new FlightSegmentResultSetMapper()
        );
    }

}
