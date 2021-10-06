package org.h2o.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.h2o.dao.SignUpDao;
import org.h2o.domain.SignUpDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

@Repository
public class SignUpDaoImpl implements SignUpDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void saveUser(SignUpDTO signUpDto) {
		String sql = "insert into users(username,password,enabled) values(?,?,?)";
		String sql2 = "insert into authorities(username,authority) values(?,?)";
//		jdbcTemplate.update(sql,signUpDto.getUsername(),signUpDto.getPassword(),1);
//		jdbcTemplate.update(sql2,signUpDto.getUsername(),"USER");

		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {

				ps.setString(1, signUpDto.getUsername());
				ps.setString(2, signUpDto.getPassword());
				ps.setInt(3, 1);
			}
		});
		jdbcTemplate.update(sql2, ps -> {
			ps.setString(1, signUpDto.getUsername());
			ps.setString(2, "USER");
		});

	}

}
