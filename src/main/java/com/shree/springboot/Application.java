package com.shree.springboot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class Application {
	private static final Logger logger = LogManager.getLogger(Application.class);
	public static void main(String[] args) {
		
		
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		 logger.debug("Debugging log");
	        logger.info("Info log");
	        logger.warn("Hey, This is a warning!");
	        logger.error("Oops! We have an Error. OK");
	        logger.fatal("Damn! Fatal error. Please fix me.");
	    }
	

	@Profile("prod")
	@Bean
	public String dummy() {
		return "";
	}
}
