package org.h2o.dao.impl;

import java.security.Principal;

import org.h2o.dao.UserDetailsDao;
import org.h2o.domain.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDetailsDaoImpl implements UserDetailsDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public UserDetails findUserByUsername(String username) {
		
		String sql="select * from user_details where username=?";
		Object[] args = {username};
		UserDetails userDetails = jdbcTemplate.queryForObject(sql, args, new BeanPropertyRowMapper<UserDetails>(UserDetails.class));
//		System.out.println("userDetails:: "+userDetails);
		return userDetails;
	}

	@Override
	public void changePassword(String newPassword, String username) {
		String sql="update user_details set password=? where username=?";
		jdbcTemplate.update(sql, pss ->{
			pss.setString(1, newPassword);
			pss.setString(2, username);
		});
		System.out.println("Password Changed");
		
	}

	@Override
	public void deleteUser(String username) {
		String sql = "delete from user_details where username=?";
		String sql2 = "delete from user_roles where username=?";
		int update = jdbcTemplate.update(sql2, pss->{
			pss.setString(1, username);
		});
		int update2 = jdbcTemplate.update(sql, pss->{
			pss.setString(1, username);
		});
//		System.out.println("sql1: "+update+" sql2: "+update2);
		if(update == 1 && update2 == 1) {
			System.out.println("User Deleted with username:  "+username);	
		}
		
	}

}
