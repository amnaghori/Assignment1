package com.jdbc.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jdbc.test.dao.EmailDAO;
import com.jdbc.test.dao.EmailDAOImpl;
import com.jdbc.test.entities.Email;
import com.jdbc.test.services.EmailService;
import com.jdbc.test.services.MailService;

@RestController
public class EmailController {
	@Autowired
	private EmailService emailService;
	@Autowired
	private MailService service;

	@GetMapping("/index")
	public String sendEmail() {
		List<Email> email = emailService.getAllEmails();
		String s = "";
		for (Email e : email) {
			int i = service.sendEmail(e);
			System.out.println(i);
			if (i == 1) {
				s += e.getEmail() + ", ";
				System.out.println(e);
			}
		}

		return "Email successfully sent to: " + s;
	}

	@GetMapping("/update")
	public void updateDB() {
		int[] rows = emailService.update();
		System.out.println("Number of rows updated: " + rows.length);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addEmail(@RequestBody Email email) {
		emailService.addEmail(email);
	}
}
