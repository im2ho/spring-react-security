package com.signup.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

//데이터 베이스에 테이블이 존재하지 않을 경우 테이블 생성
@Configuration
public class DatabaseConfig {

	//DataSourceInitializer 객체 :
		//DB 초기화를 수행할 수 있는데이터 소스와 Populator 설정 기능 포함
	//ResourceDatabasePopulator :
		//addScript 데이터베이스를 초기화하고 추가할 스크립트 파일을 추가
		//sql/create-members-table.sql : sql에 추가할 DDL문을 작성
	@Bean
	public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
		
		DataSourceInitializer initializer = new DataSourceInitializer();
		initializer.setDataSource(dataSource);
		initializer.setDatabasePopulator(databasePopulator(dataSource));
		return initializer;
	}

	private ResourceDatabasePopulator databasePopulator(DataSource dataSource) {
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		//테이블이 존재하지 않을 경우에 생성
		if(!tableExists(dataSource, "Members")) {
			populator.addScript(new ClassPathResource("sql/create-members-table.sql"));
		}
		return populator;
	}
	
	private boolean tableExists(DataSource dataSource, String tableName) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String query = "SELECT COUNT(*) FROM ALL_TABLES WHERE TABLE_NAME=UPPER(?)";
		int count = jdbcTemplate.queryForObject(query, Integer.class, tableName.toUpperCase());
		return count > 0 ;
	}
}
