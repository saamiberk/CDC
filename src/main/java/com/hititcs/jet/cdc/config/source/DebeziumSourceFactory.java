package com.hititcs.jet.cdc.config.source;

import com.hazelcast.enterprise.jet.cdc.ChangeRecord;
import com.hazelcast.enterprise.jet.cdc.DebeziumCdcSources;
import com.hazelcast.jet.pipeline.StreamSource;
import com.hititcs.jet.cdc.config.CdcConfig;
import io.debezium.connector.oracle.OracleConnector;

public class DebeziumSourceFactory {

    public static StreamSource<ChangeRecord> getDebeziumSource() {
        return DebeziumCdcSources
                .debezium("source", OracleConnector.class)
                .setProperty("database.hostname", CdcConfig.getDbHost())
                .setProperty("database.port", CdcConfig.getDbPort())
                .setProperty("database.user", CdcConfig.getDbUser())
                .setProperty("database.password", CdcConfig.getDbPassword())
                .setProperty("database.dbname", CdcConfig.getDbName())
                .setProperty("schema.include.list", CdcConfig.getSchemaIncludeList())
                .setTableIncludeList(CdcConfig.getTableIncludeList())
                .setProperty("snapshot.mode", CdcConfig.getSnapShotMode())
                .setProperty("decimal.handling.mode", CdcConfig.getDecimalHandlingMode())
                .setProperty("include.schema.changes", CdcConfig.getIncludeSchemaChanges())
                .setProperty("log.mining.strategy", CdcConfig.getLogMiningStrategy())
                .build();
    }

}
