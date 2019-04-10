package com.example.Run;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerWebApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(ServerWebApplication.class);
	public static void main(String[] args) {
		LOGGER.info(">>> Entered application...");
		SpringApplication.run(ServerWebApplication.class, args);
	}
}
