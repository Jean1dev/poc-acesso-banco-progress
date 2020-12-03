package com.logistica.integracoes.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
        entityManagerFactoryRef = "ems2CadEntityManagerFactory",
        transactionManagerRef = "ems2CadTransactionManager",
        basePackages = "com.logistica.integracoes.db.ems2cad.domain"
)
public class Ems2CadConfig {

    @Primary
    @Bean(name = "ems2CadDataSource")
    @ConfigurationProperties(prefix = "ems2cad.datasource")
    public HikariDataSource em2CadDataSource() {
        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .build();
    }

    @Primary
    @Bean(name = "ems2CadEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean ems2CadEntityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("ems2CadDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource)
                .packages("com.logistica.integracoes.db.ems2cad.domain")
                .persistenceUnit("ems2cad")
                .build();
    }

    @Primary
    @Bean(name = "ems2CadTransactionManager")
    public PlatformTransactionManager ems2CadTransactionManager(@Qualifier("ems2CadEntityManagerFactory")EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
