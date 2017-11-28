package com.app.sample.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;

@Configuration
public class PostgresConfig {

    public PostgresConfig() {
    }

    @Configuration
    @Profile("local")
    @EnableJpaRepositories(entityManagerFactoryRef = "postgresEntityManagerFactory", basePackages = "com.app.sample.rsa")
    static class PostgresLocalConfig {

        @Bean
        @Primary
        LocalContainerEntityManagerFactoryBean postgresEntityManagerFactory(
                EntityManagerFactoryBuilder builder) throws IOException {
            return builder.dataSource(postgresDataSource())
                    .packages("com.app.sample.models")
                    .persistenceUnit("postgres").build();
        }

        @Bean
        @Primary
        @ConfigurationProperties(prefix = "datasource.postgres")
        DataSource postgresDataSource() throws IOException {
            EmbeddedPostgres pg = EmbeddedPostgres.builder().setPort(15445)
                    .start();
            return pg.getPostgresDatabase();
        }
    }


}
