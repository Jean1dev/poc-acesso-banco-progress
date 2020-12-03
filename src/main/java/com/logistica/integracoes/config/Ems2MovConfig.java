package com.logistica.integracoes.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "ems2MovEntityManagerFactory",
        transactionManagerRef = "ems2MovTransactionManager",
        basePackages = "com.logistica.integracoes.db.ems2mov.domain"
)
public class Ems2MovConfig {

    @Bean(name = "ems2MovDataSource")
    @ConfigurationProperties(prefix = "ems2mov.datasource")
    public HikariDataSource em2MovDataSource() {
        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .build();
    }

    @Bean(name = "ems2MovEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean ems2MovEntityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("ems2MovDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource)
                .packages("com.logistica.integracoes.db.ems2mov.domain")
                .persistenceUnit("ems2mov")
                .build();
    }

    @Bean(name = "ems2MovTransactionManager")
    public PlatformTransactionManager ems2MovTransactionManager(@Qualifier("ems2MovEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
