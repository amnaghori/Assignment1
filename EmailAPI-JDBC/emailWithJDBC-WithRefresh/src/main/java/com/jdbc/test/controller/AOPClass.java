package com.jdbc.test.controller;

import java.io.IOException;
import java.util.Properties;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AOPClass {
	@Autowired
	private PropertiesConfig props;
	
	@Before("execution(public String sendEmail())")
	public void refresh() throws IOException {
		Resource resource1 = new ClassPathResource("/test1.properties");
		Properties properties1 = PropertiesLoaderUtils.loadProperties(resource1);
		props.setEmail1(properties1.getProperty("test1.email"));
		props.setSubject1(properties1.getProperty("test1.subject"));
		props.setContent1(properties1.getProperty("test1.content"));
		
		Resource resource2 = new ClassPathResource("/test2.properties");
		Properties properties2 = PropertiesLoaderUtils.loadProperties(resource2);
		props.setEmail2(properties2.getProperty("test2.email"));
		props.setSubject2(properties2.getProperty("test2.subject"));
		props.setContent2(properties2.getProperty("test2.content"));
		
		Resource resource3 = new ClassPathResource("/test3.properties");
		Properties properties3 = PropertiesLoaderUtils.loadProperties(resource3);
		props.setEmail3(properties3.getProperty("test3.email"));
		props.setSubject3(properties3.getProperty("test3.subject"));
		props.setContent3(properties3.getProperty("test3.content"));
		
		System.out.println("aspect executed....");
	}
}
