package com.jdbc.test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.jdbc.test.entities.Email;

@Service
public class MailService {
	private JavaMailSender javaMailSender;

	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public int sendEmail(Email rcv) {
		int sent;
		try {
			SimpleMailMessage mail = new SimpleMailMessage();

			mail.setTo(rcv.getEmail());
			mail.setSubject(rcv.getSubject());
			mail.setText(rcv.getContent());

			javaMailSender.send(mail);
			sent = 1;
			
		} catch (MailException e) {
			System.err.println("Exception in mail");
			sent = -1;
		}
		return sent;
	}

}