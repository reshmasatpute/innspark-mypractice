package com.innspark.clickhouse_based.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class JdbcConfiguration {

	@Bean
	public JdbcTemplate jdbcTemplate() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.clickhouse.jdbc.ClickHouseDriver");
		dataSource.setUrl("jdbc:clickhouse://localhost:8123/default");
		dataSource.setUsername("default");
		dataSource.setPassword("reshma123");
		return new JdbcTemplate(dataSource);
	}
}
