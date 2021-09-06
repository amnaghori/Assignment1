package com.jdbc.test.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.jdbc.test.entities.Email;

@Component("emailDAO")
public class EmailDAOImpl implements EmailDAO {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

//	@Override
//	public void update(Email receiver) {
////		String query = "update receiver set subject = ?, content =? where email = ?";
////		int rows = jdbcTemplate.update(query, receiver.getSubject(), receiver.getContent(), receiver.getEmail());
//
//		String query = "update receiver set subject = :subject, content = :content where email = :email";
//
//		Map<String, Object> paramMap = new HashMap<>();
//		paramMap.put("email", receiver.getEmail());
//		paramMap.put("subject", receiver.getSubject());
//		paramMap.put("content", receiver.getContent());
//
//		System.out.println(query + " [" + paramMap + "]");
//
//		int rows = namedParameterJdbcTemplate.update(query, paramMap);
//
//		System.out.println(rows + " row(s) updated successfully!");
//	}

	@Override
	public int[] batchUpdate(List<Email> receiversList) {
		String query = "update receiver set subject = :subject, content = :content where email = :email";

		Map<String, Object>[] batchOfInputs = new HashMap[receiversList.size()];
		int count = 0;
		for (Email receiver : receiversList) {
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("email", receiver.getEmail());
			paramMap.put("subject", receiver.getSubject());
			paramMap.put("content", receiver.getContent());
			batchOfInputs[count++] = paramMap;
		}

		return namedParameterJdbcTemplate.batchUpdate(query, batchOfInputs);
	}

	@Override
	public List<Email> getAll() {
		String query = "select * from receiver";
		return namedParameterJdbcTemplate.query(query, (rs, rowNum) -> {
			Email e = new Email();
			e.setId(rs.getInt(1));
			e.setEmail(rs.getString(2));
			e.setSubject(rs.getString(3));
			e.setContent(rs.getString(4));
			return e;
		});
	}

	@Override
	public void save(Email receiver) {
		String query = "insert into receiver(email,subject,content) values(?,?,?)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
	    paramMap.put("email", receiver.getEmail());
	    paramMap.put("subject", receiver.getSubject());
	    paramMap.put("content", receiver.getContent());
		int rows = namedParameterJdbcTemplate.update(query, paramMap);

	}

}
