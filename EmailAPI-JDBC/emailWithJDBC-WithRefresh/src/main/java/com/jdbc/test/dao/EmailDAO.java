package com.jdbc.test.dao;

import java.util.List;

import com.jdbc.test.entities.Email;



public interface EmailDAO {
	public void update(Email recvr);
	public int[] batchUpdate(List<Email> emails);
	public List<Email> getAll();
}
