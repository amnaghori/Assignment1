package com.jdbc.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.jdbc.test.controller.EmailController;
import com.jdbc.test.dao.EmailDAO;
import com.jdbc.test.entities.Email;
import com.jdbc.test.services.EmailService;
import com.jdbc.test.services.MailService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(EmailController.class)
public class TestApplicationTests {
	@Autowired
	MockMvc mockMvc;

	@MockBean
	EmailDAO emailDAO;
	@MockBean
	EmailService emailService;
	@MockBean
	MailService mailService;

	private final List<Email> emails = new ArrayList<>();

	@Test
	public void test1() throws Exception {
		Email record_1 = new Email("testemail2@", "Welcome", "Testing.....");
		record_1.setId(1);
		emails.add(record_1);
		Mockito.when(emailService.getAllEmails()).thenReturn(emails);
		Mockito.when(mailService.sendEmail(emails.get(0))).thenReturn(1);
		MvcResult res = mockMvc.perform(MockMvcRequestBuilders.get("/index").contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		int status = res.getResponse().getStatus();
		assertEquals(200, status); //request succeeded
		String content = res.getResponse().getContentAsString();
		System.out.println(content);
	}

	@Test
	void test2() throws Exception {
		int[] arr = {1};
		Mockito.when(emailService.update()).thenReturn(arr);
		MvcResult res = mockMvc.perform(MockMvcRequestBuilders.get("/update").contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		int status = res.getResponse().getStatus();
		assertEquals(200, status); //request succeeded
	}

}
