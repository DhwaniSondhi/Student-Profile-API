package org.practice;

import javax.sql.DataSource;

import org.practice.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("org.practice")
@EnableWebMvc
@EnableTransactionManagement
public class ConfigurationFile {
	
	@Bean("dataSource")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/practice");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
	
	@Bean("txManager")
	public TransactionManager transactionManager(@Autowired DataSource dataSource) {
		DataSourceTransactionManager txManager=new DataSourceTransactionManager();
		txManager.setDataSource(dataSource);
		return txManager;
	}

}
