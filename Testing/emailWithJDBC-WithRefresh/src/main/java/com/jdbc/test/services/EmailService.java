package com.jdbc.test.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdbc.test.controller.PropertiesConfig;
import com.jdbc.test.dao.EmailDAO;
import com.jdbc.test.entities.Email;

@Service
public class EmailService {
	@Autowired
	EmailDAO emailDao;
	@Autowired
	private PropertiesConfig props;
	
	public List<Email> getAllEmails() {
		return emailDao.getAll();
	}
	
	public int[] update() {
		List<Email> receiverList = createReceiverList();
		return emailDao.batchUpdate(receiverList);
	}
	
	public void addEmail(Email email) {
		emailDao.save(email);
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