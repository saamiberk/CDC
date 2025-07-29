package com.hititcs.jet.cdc.batch;

import com.hazelcast.jet.pipeline.BatchSource;
import com.hazelcast.jet.pipeline.Pipeline;
import com.hazelcast.jet.pipeline.Sinks;
import com.hazelcast.jet.pipeline.Sources;
import com.hititcs.jet.cdc.config.CacheConstants;
import com.hititcs.jet.cdc.config.CdcConfig;
import com.hititcs.jet.cdc.mapper.resultset.InventoryResultSetMapper;
import com.hititcs.jet.cdc.record.Inventory;

public class InventoryBatchSourceFactory {

    public static Pipeline createPipeline() {
        Pipeline inventoryBatchPipeline = Pipeline.create();
        inventoryBatchPipeline.readFrom(create())
                .writeTo(Sinks.map(CacheConstants.CACHE_NAME_INVENTORY,
                        Inventory::getCustomKey,
                        fs -> fs))
                .setLocalParallelism(Runtime.getRuntime().availableProcessors());
        return inventoryBatchPipeline;// Key-Value mapping

    }

    public static BatchSource<Inventory> create() {
        return Sources.jdbc(CdcConfig.getConnectionString(),
                "SELECT i.*\n" +
                        "FROM INVENTORY i\n" +
                        "JOIN FLT_SEGMENT fs ON i.SEG_ISN = fs.SEG_ISN " +
                        "WHERE SCH_DEP_DT >= TRUNC(SYSDATE)\n" +
                        "  AND SCH_DEP_DT <= TRUNC(ADD_MONTHS(SYSDATE, 12))",
                new InventoryResultSetMapper()
        );
    }
}
