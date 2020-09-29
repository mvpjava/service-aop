package com.mvpjava.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication (scanBasePackages ="com.mvpjava")
@EnableAspectJAutoProxy
public class ServiceAopApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(ServiceAopApplication.class, args);
	}

}
