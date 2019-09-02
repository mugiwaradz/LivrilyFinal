package com.zinou.springboot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.zinou.springboot.web")
public class LivrilyApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivrilyApplication.class, args);
	}
}
