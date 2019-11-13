package com.athenahealth.quality.cdc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.CleanupConfig;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	public CleanupConfig getCleanupConfig(){
		CleanupConfig config = new CleanupConfig();
		config.cleanupOnStart();
		config.cleanupOnStop();
		return config;
	}

}
