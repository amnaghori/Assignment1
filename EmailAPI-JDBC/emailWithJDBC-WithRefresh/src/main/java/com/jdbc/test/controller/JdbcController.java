package com.jdbc.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdbc.test.dao.EmailDAOImpl;
import com.jdbc.test.entities.Email;
import com.jdbc.test.services.EmailService;

@RestController
public class JdbcController {
	@Autowired
	private EmailDAOImpl emailDao;
	@Autowired
	private EmailService service;
	@Autowired
	private PropertiesConfig props;

	@GetMapping("/index")
	public String sendEmail() {
		updateDB();
		List<Email> email = emailDao.getAll();
		String s = "";
		for (Email e : email) {
			try {
				service.sendEmail(e);
			} catch (MailException mailException) {
				System.out.println(mailException);
			}
			s += e.getEmail() + ", ";
			System.out.println(e);
		}

		return "Email successfully sent to: " + s;
	}
	
	public void updateDB() {
		List<Email> receiverList = createReceiverList();
		int[] rows = emailDao.batchUpdate(receiverList);
		System.out.println("Number of rows updated: " + rows.length);
	}

	public List<Email> createReceiverList() {
		Email rcv1 = new Email(props.getEmail1(), props.getSubject1(), props.getContent1());
		Email rcv2 = new Email(props.getEmail2(), props.getSubject2(), props.getContent2());
		Email rcv3 = new Email(props.getEmail3(), props.getSubject3(), props.getContent3());
		List<Email> rcvList = new ArrayList<Email>();
		rcvList.add(rcv1);
		rcvList.add(rcv2);
		rcvList.add(rcv3);
		return rcvList;
	}
}
