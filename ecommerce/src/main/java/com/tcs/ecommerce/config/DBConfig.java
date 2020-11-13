package com.tcs.ecommerce.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:db.properties")
@ComponentScan("com.tcs.ecommerce")
public class DBConfig {

	@Autowired
	private Environment environment;
	
	@Bean
	//@Lazy
	public DataSource getMySQLDataSource() {
		System.out.println("In DataSource creation");
		BasicDataSource dataSource = new BasicDataSource();
		
		dataSource.setDriverClassName(environment.getProperty("db.driver"));
		dataSource.setUrl(environment.getProperty("db.url"));
		dataSource.setUsername(environment.getProperty("db.username"));
		dataSource.setPassword(environment.getProperty("db.password"));
		return dataSource;
	}
}
