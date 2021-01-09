package com.example;

import com.example.spring.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

@Configuration
public class ApplicationPersistenceConfiguration {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Environment.DB_DRIVER);
        dataSource.setUrl(Environment.getDatabaseURL(Environment.REGISTRY_DB));
        dataSource.setUsername("root");
        Environment.SPRING_ENVIRONMENT.getProperty("db.username");
        Environment.SPRING_ENVIRONMENT.getProperty("db.password");
        return dataSource;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        final var jpaVendorAdaptor = new HibernateJpaVendorAdapter();
        jpaVendorAdaptor.setGenerateDdl(true);
        jpaVendorAdaptor.setShowSql(false);
        jpaVendorAdaptor.setDatabase(Database.MYSQL);
        jpaVendorAdaptor.setDatabasePlatform("org.hibernate.dialect.MySQL57Dialect");
        return jpaVendorAdaptor;
    }
}
