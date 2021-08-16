package com.assignment.testapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.testapp.model.Email;
import com.assignment.testapp.services.EmailService;

@RestController
public class EmailConfig {
	@Autowired
	private EmailService service;

	@Autowired
	private Email email;
	
	@Value("${emailContent}")
	private String content;
	@Value("${emailSubject}")
	private String subject;
	@Value("${ReceiverEmailAddress}")
	private String sendTo;

	@GetMapping("/sendEmail")
	public String send() {
		email.setEmailAddress(sendTo);
		email.setSubject(subject);
		
		try {
			service.sendEmail(email);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Email sent successfully having content : " + email.getContent();
	}
}