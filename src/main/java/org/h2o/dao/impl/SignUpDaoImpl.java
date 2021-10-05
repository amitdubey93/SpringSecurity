package org.h2o.dao.impl;

import org.h2o.dao.SignUpDao;
import org.h2o.domian.SignUpDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SignUpDaoImpl implements SignUpDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void saveUser(SignUpDTO signUpDto) {
		String sql = "insert into users(username,password,enabled) values(?,?,?)";
		String sql2 = "insert into authorities(username,authority) values(?,?)";
		jdbcTemplate.update(sql,signUpDto.getUsername(),signUpDto.getPassword(),1);
		jdbcTemplate.update(sql2,signUpDto.getUsername(),"USER");
	}

}
