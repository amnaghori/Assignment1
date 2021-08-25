package com.jdbc.test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.jdbc.test.entities.Email;

@Service
public class EmailService {
	private JavaMailSender javaMailSender;

	@Autowired
	public EmailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendEmail(Email rcv) throws MailException {

		SimpleMailMessage mail = new SimpleMailMessage();

		mail.setTo(rcv.getEmail());
		mail.setSubject(rcv.getSubject());
		mail.setText(rcv.getContent());

		javaMailSender.send(mail);
	}

}