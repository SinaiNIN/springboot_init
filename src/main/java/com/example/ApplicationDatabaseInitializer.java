package com.example;

import com.example.spring.Environment;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;

import static java.lang.String.format;

@Slf4j
public class ApplicationDatabaseInitializer {

    private static final String DB_EXISTS_QUERY = "SHOW databases LIKE '%s'";

    static void verify() throws Exception {
        log.info("Verifying application databases have been initialized");
        try (final Connection connection = DriverManager.getConnection(Environment.getDatabaseURL())) {
            verify(connection, Environment.REGISTRY_DB);
        }
    }

    private static void verify(final Connection connection,
                               final String database) throws Exception {
        try (final var statement = connection.createStatement()) {
            if (!statement.executeQuery(format(DB_EXISTS_QUERY, database)).next()) {
                log.warn("'{}' database was not found, proceeding with initialization", database);
                create(connection, database);
            }
        }
    }

    private static void create(final Connection connection,
                               final String database) throws Exception {
        try (final var statement = connection.createStatement()) {
            statement.execute(format("CREATE DATABASE %s;", database));
        }
    }
}
