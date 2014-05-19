package com.mikoglace.market.config;

import javax.sql.DataSource;

import liquibase.integration.spring.SpringLiquibase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertyResolver;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * This class configures the database. 
 */
@Configuration
@EnableJpaRepositories("com.mikoglace.market.repository")
@EnableTransactionManagement
public class DatabaseConfiguration implements EnvironmentAware {

	Logger log = LoggerFactory.getLogger(this.getClass());

	private PropertyResolver propertyResolver;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setEnvironment(Environment environment) {
		log.debug("Set environment");
		propertyResolver = new RelaxedPropertyResolver(environment, "spring.datasource.");
	}
	
	@Bean
	public DataSource dataSource() {
		log.debug("Configuring dataSource");
		
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		
		String driverClassName = propertyResolver.getProperty("driverClassName");
		String url = propertyResolver.getProperty("url");
		String username = propertyResolver.getProperty("username");
		String password = propertyResolver.getProperty("password");
		
		driverManagerDataSource.setDriverClassName(driverClassName);
		driverManagerDataSource.setUrl(url);
		driverManagerDataSource.setUsername(username);
		driverManagerDataSource.setPassword(password);
		
		return driverManagerDataSource;
	}
	
	@Bean
    public SpringLiquibase liquibase() {
        log.debug("Configuring Liquibase");
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource());
        liquibase.setChangeLog("classpath:config/liquibase/master.xml");
        liquibase.setContexts("test, development, production");
        return liquibase;
    }

}
