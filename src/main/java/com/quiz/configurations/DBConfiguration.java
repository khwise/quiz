package com.quiz.configurations;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@EnableTransactionManagement
@Configuration
public class DBConfiguration {
    private final Logger log = LoggerFactory.getLogger(DBConfiguration.class);

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        log.info("DataSource.");
        HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig());
        return hikariDataSource;
    }

    @ConfigurationProperties(prefix = "config.hikari")
    @Bean(name = "hikariConfig")
    public HikariConfig hikariConfig() {
        log.info("Hikari Configuration.");
        return new HikariConfig();
    }


}
