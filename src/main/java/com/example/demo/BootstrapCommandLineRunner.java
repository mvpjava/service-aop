package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapCommandLineRunner implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(DiscountRepository.class);
	
	final DiscountGenerator service;
	
	public BootstrapCommandLineRunner (DiscountGenerator service) {
		this.service = service;
	}
	
	@Override
	public void run(String... args) throws Exception {
		Product product = new Product("Spring Book", 19.99D);
		logger.info("Random discount is " + service.calculateDiscountFor(product));
	}

}
