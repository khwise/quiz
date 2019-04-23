package com.quiz.configurations;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
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

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory (
            @Qualifier("dataSource") DataSource dataSource, EntityManagerFactoryBuilder emf) {
        log.info("EntityManagerFactory.");
        Map<String, String> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "none");
        properties.put("hibernate.show-sql", "true");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        return emf
                .dataSource(dataSource)
                .packages("com.quiz.core")
                .properties(properties)
                .build();
        // todo : packages 범위 및 포함되는 종류 (Bean 인지 Repository 인지) 확인
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("entityManagerFactory") EntityManagerFactory em) {
        log.info("TransactionManagerFactory.");
        JpaTransactionManager tm = new JpaTransactionManager();
        tm.setEntityManagerFactory(em);
        return tm;
    }
}
