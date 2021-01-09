package com.example.spring;

import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.support.ResourcePropertySource;

import java.net.URL;

import static java.lang.String.format;

public class Environment {

    public static final String DB_DRIVER = com.mysql.cj.jdbc.Driver.class.getCanonicalName();
    public static final String REGISTRY_DB = "app";

    private static final String PROPERTY_FILE = "application.properties";
    public static final StandardEnvironment SPRING_ENVIRONMENT = new StandardEnvironment() {
        @Override
        protected void customizePropertySources(final MutablePropertySources propertySources) {
            try {
                final URL resource = Environment.class.getClassLoader().getResource(PROPERTY_FILE);
                if (resource != null) {
                    propertySources.addLast(new ResourcePropertySource(resource.toString()));
                }
                super.customizePropertySources(propertySources);
            } catch (final Exception e) {
                e.printStackTrace();
            }
        }
    };

    public static String getDatabaseURL() {
        return getDatabaseURL("");
    }

    public static String getDatabaseURL(final String database) {
        return format("jdbc:mysql://%s/%s?autoReconnect=true&useSSL=false&user=%s&password=%s%s",
                SPRING_ENVIRONMENT.getProperty("db.endpoint"),
                database,
                SPRING_ENVIRONMENT.getProperty("db.username"),
                SPRING_ENVIRONMENT.getProperty("db.password"),
                "");
    }
}
