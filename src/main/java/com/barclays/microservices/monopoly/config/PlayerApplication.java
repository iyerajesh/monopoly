package com.barclays.microservices.monopoly.config;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 * @author Rajesh Iyer
 */

@Configuration
@ComponentScan({ "com.barclays" })
@EnableAutoConfiguration

public class PlayerApplication {

	private static final Logger logger = LoggerFactory.getLogger(PlayerApplication.class);

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(PlayerApplication.class, args);
	}

}
