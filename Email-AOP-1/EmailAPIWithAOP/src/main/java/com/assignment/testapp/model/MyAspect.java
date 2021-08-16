package com.assignment.testapp.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assignment.testapp.services.EmailService;

@Component
@Aspect
public class MyAspect {
	@Autowired
	Email s;
	
	@Before("execution(public String send())")
	public void read() {
		Properties prop = new Properties();
		String file = "application.properties";
		InputStream fins = getClass().getClassLoader().getResourceAsStream(file);
		try {
			if (fins != null)
				prop.load(fins);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String val = prop.getProperty("emailContent");
		s.setContent(val);
		System.out.println("Aspect executed!!");
	}
}
