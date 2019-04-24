package com.quiz.configurations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@Configuration
public class JpaConfiguration {

    private final Logger log = LoggerFactory.getLogger(JpaConfiguration.class);

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

    @Bean
    public AuditorAware<Long> auditorAware() {
        return new AuditorAwareImpl();
    }

    public class AuditorAwareImpl implements AuditorAware<Long> {

        @Override
        public Optional<Long> getCurrentAuditor() {
            return Optional.of(10001L);
        }
    }
}
