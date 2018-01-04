package com.tml.springkafka;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@MapperScan(basePackages = "com.tml.springkafka.dao")
public class SpringKafkaApplication {

	@Bean
	@ConfigurationProperties(prefix = "datasource")
	DataSource dataSource() {
		return  new DruidDataSource();
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaApplication.class, args);
	}
}
