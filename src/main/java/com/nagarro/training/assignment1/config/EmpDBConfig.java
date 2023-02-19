//package com.nagarro.training.assignment1.config;
//
//import javax.activation.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//@Configuration
//public class EmpDBConfig {
//
//	@Autowired
//	private Environment environment;
//
//	@Bean
//	public DataSource dataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//		dataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
//		dataSource.setUrl(environment.getProperty("jdbc.url"));
//		dataSource.setUsername(environment.getProperty("jdbc.username"));
//		dataSource.setPassword(environment.getProperty("jdbc.password"));
//
//		return (DataSource) dataSource;
//	}
//
//}