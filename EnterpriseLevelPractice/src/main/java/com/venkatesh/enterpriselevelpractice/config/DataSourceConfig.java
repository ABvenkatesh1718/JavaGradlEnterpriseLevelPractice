package com.venkatesh.enterpriselevelpractice.config;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Value("${boot.db.url}")
    private String url;

    @Value("${boot.db.username}")
    private String username;

    @Value("${boot.db.password}")
    private String password;

    @Value("${boot.datasource.driver-class-name:org.postgresql.Driver}")
    private String driverClassName;

    @Value("${boot.hikari.pool-name:EnterpriseHikariCP}")
    private String poolName;

    @Value("${boot.hikari.maximum-pool-size:4}")
    private int maxPoolSize;

    @Value("${boot.hikari.minimum-idle:2}")
    private int minIdle;

    /**
     * Explicitly builds HikariDataSource with pool parameters.
     */
    @Bean
    @Primary
    public DataSource dataSource() {
        HikariDataSource hikariDataSource = DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .driverClassName(driverClassName)
                .url(url)
                .username(username)
                .password(password)
                .build();

        // Apply custom Hikari pool controls
        hikariDataSource.setPoolName(poolName);
        hikariDataSource.setMaximumPoolSize(maxPoolSize);
        hikariDataSource.setMinimumIdle(minIdle);

        return hikariDataSource;
    }

    /**
     * Exposes custom JdbcTemplate configured with our manual DataSource.
     */
    @Bean
    @Primary
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}