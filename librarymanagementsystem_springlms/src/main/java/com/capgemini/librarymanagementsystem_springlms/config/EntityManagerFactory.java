package com.capgemini.librarymanagementsystem_springlms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
public class EntityManagerFactory {
	@Bean
	public LocalContainerEntityManagerFactoryBean getEntityManager() {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setPersistenceUnitName("TestPersistence");
		return factory;
	}

}
