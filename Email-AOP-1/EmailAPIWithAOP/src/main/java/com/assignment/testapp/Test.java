package com.assignment.testapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;

import com.assignment.testapp.model.Email;

@SpringBootApplication
public class Test {

	public static void main(String[] args) {
		SpringApplication.run(Test.class, args);
	}
}