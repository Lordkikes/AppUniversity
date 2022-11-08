package com.university.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppUniversityApplication {

	public static void main(String[] args) {
		String[] beanDefinitionNames = SpringApplication.run(AppUniversityApplication.class, args).getBeanDefinitionNames();
		for (String st : beanDefinitionNames) {
			System.out.println(st);
		}
	}

}
