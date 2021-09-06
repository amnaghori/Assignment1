package com.jdbc.test.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({ "classpath:test1.properties", "classpath:test2.properties", "classpath:test3.properties" })
public class PropertiesConfig {
	
	@Value("${test1.email}")
	private String email1;
	@Value("${test2.email}")
	private String email2;
	@Value("${test3.email}")
	private String email3;

	@Value("${test1.subject}")
	private String subject1;
	@Value("${test2.subject}")
	private String subject2;
	@Value("${test3.subject}")
	private String subject3;

	@Value("${test1.content}")
	private String content1;
	@Value("${test2.content}")
	private String content2;
	@Value("${test3.content}")
	private String content3;
	
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public String getEmail3() {
		return email3;
	}
	public void setEmail3(String email3) {
		this.email3 = email3;
	}
	public String getSubject1() {
		return subject1;
	}
	public void setSubject1(String subject1) {
		this.subject1 = subject1;
	}
	public String getSubject2() {
		return subject2;
	}
	public void setSubject2(String subject2) {
		this.subject2 = subject2;
	}
	public String getSubject3() {
		return subject3;
	}
	public void setSubject3(String subject3) {
		this.subject3 = subject3;
	}
	public String getContent1() {
		return content1;
	}
	public void setContent1(String content1) {
		this.content1 = content1;
	}
	public String getContent2() {
		return content2;
	}
	public void setContent2(String content2) {
		this.content2 = content2;
	}
	public String getContent3() {
		return content3;
	}
	public void setContent3(String content3) {
		this.content3 = content3;
	}

}
