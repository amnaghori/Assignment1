package com.sl.configclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sl.configclient.model.Email;
import com.sl.configclient.service.EmailService;

@RefreshScope
@RequestMapping("/home")
@RestController
public class EmailConfig {
	@Autowired
	private EmailService notificationService;

	@Autowired
	private Email email;
	
	@Value("${message}")
	private String content;
	@Value("${emailSubject}")
	private String subject;
	@Value("${emailAddress}")
	private String sendTo;

	@GetMapping("/sendEmail")  
	public String send() {
		String msg = null;

		email.setEmailAddress(sendTo);
		email.setSubject(subject);
		email.setContent(content);

		try {
			notificationService.sendEmail(email);
			msg = "Email sent successfully!!";
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return msg;
	}
}