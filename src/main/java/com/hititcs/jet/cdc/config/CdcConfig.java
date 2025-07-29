package com.hititcs.jet.cdc.config;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CdcConfig {
    private static final Properties properties = new Properties();

    private static String dbHost;
    private static String dbPort;
    private static String dbUser;
    private static String dbPassword;
    private static String dbName;

    private static String schemaIncludeList;
    private static String tableIncludeList;

    private static String decimalHandlingMode;
    private static String includeSchemaChanges;

    private static String logMiningStrategy;

    private static String snapShotMode;

    private static String connectionString;

    public static void load() {
        try (InputStream input = CdcConfig.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            if (input == null) {
                throw new RuntimeException("application.properties not found!");
            }
            properties.load(input);

            dbHost = properties.getProperty("debezium.database.hostname");
            dbPort = properties.getProperty("debezium.database.port");
            dbUser = properties.getProperty("debezium.database.user");
            dbPassword = properties.getProperty("debezium.database.password");
            dbName = properties.getProperty("debezium.database.dbname");

            schemaIncludeList = properties.getProperty("debezium.schema.include.list");
            tableIncludeList = properties.getProperty("debezium.table.include.list");

            decimalHandlingMode = properties.getProperty("debezium.decimal.handling.mode");
            includeSchemaChanges = properties.getProperty("debezium.include.schema.changes");

            logMiningStrategy = properties.getProperty("debezium.log.mining.strategy");

            snapShotMode = properties.getProperty("debezium.snapshot.mode");

            connectionString = "jdbc:oracle:thin:" +  dbUser + "/" + dbPassword + "@//" + dbHost + ":1521/" + dbName;


        } catch (IOException e) {
            throw new RuntimeException("Config not read", e);
        }
    }

    public static String getDbHost() {
        return dbHost;
    }

    public static String getDbPort() {
        return dbPort;
    }

    public static String getDbUser() {
        return dbUser;
    }

    public static String getDbPassword() {
        return dbPassword;
    }

    public static String getDbName() {
        return dbName;
    }

    public static String getSchemaIncludeList() {
        return schemaIncludeList;
    }

    public static String getTableIncludeList() {
        return tableIncludeList;
    }

    public static String getDecimalHandlingMode() {
        return decimalHandlingMode;
    }

    public static String getIncludeSchemaChanges() {
        return includeSchemaChanges;
    }

    public static String getLogMiningStrategy() {
        return logMiningStrategy;
    }

    public static String getSnapShotMode() {
        return snapShotMode;
    }

    public static String getConnectionString() {
        return connectionString;
    }
}
