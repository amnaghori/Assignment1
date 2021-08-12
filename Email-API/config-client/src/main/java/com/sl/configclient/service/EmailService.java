package com.sl.configclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.sl.configclient.model.Email;

@Service
public class EmailService {
	private JavaMailSender javaMailSender;

	@Autowired
	public EmailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendEmail(Email user) throws MailException {

		SimpleMailMessage mail = new SimpleMailMessage();
		
		mail.setTo(user.getEmailAddress());
		mail.setSubject(user.getSubject());
		mail.setText(user.getContent());

		javaMailSender.send(mail);
	}

}