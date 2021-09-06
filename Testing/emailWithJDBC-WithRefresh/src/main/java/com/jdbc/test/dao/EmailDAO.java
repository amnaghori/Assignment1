package com.jdbc.test.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jdbc.test.entities.Email;

@Repository
public interface EmailDAO {
//	public void update(Email recvr);
	public int[] batchUpdate(List<Email> emails);
	public List<Email> getAll();
	public void save(Email email);
}
