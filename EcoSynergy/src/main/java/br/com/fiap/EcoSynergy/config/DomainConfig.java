package br.com.fiap.EcoSynergy.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("br.com.fiap.EcoSynergy.Model")
@EnableJpaRepositories("br.com.fiap.EcoSynergy.Repository")
@EnableTransactionManagement
public class DomainConfig {
}