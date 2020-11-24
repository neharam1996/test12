package com.tcs.studenthostel.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
@Configuration
@PropertySource("classpath:db.properties")
@ComponentScan("com.tcs.studenthostel")
public class DBConfig {
	@Autowired
	private Environment environment;
	@Bean
	public DataSource getMysqlconnection() {
		BasicDataSource datasource=new BasicDataSource();
		datasource.setDriverClassName(environment.getProperty("db.driver"));
		datasource.setUrl(environment.getProperty("db.url"));
		datasource.setUsername(environment.getProperty("db.username"));
		datasource.setPassword(environment.getProperty("db.password"));
		return datasource;
	}

}
