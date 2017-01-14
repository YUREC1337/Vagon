package com.hm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AppLoader {

	public static ApplicationContext ctx;

	public static void main(String[] args) {
		ctx = SpringApplication.run(AppLoader.class, args);
		System.out.println("Seems like all running normal");

	}

}