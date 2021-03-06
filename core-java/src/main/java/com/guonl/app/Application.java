package com.guonl.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(exclude = {RedisAutoConfiguration.class, SessionAutoConfiguration.class, DataSourceAutoConfiguration.class})
@ImportResource({ "classpath:spring/application-*.xml" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
