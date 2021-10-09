package org.h2o.service;

import org.h2o.dao.impl.UserDetailsDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class MyJdbcUserDetailsManager implements UserDetailsManager {

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private UserDetailsDaoImpl userDetailsDaoImpl;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userDetailsServiceImpl.loadUserByUsername(username);
	}

	@Override
	public void createUser(UserDetails user) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateUser(UserDetails user) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteUser(String username) {
	
		userDetailsDaoImpl.deleteUser(username);
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		Authentication currentUser = SecurityContextHolder.getContext()
				.getAuthentication();
		
		String username = currentUser.getName();
		if(username != null) {
			System.out.println("Changing Password");
			userDetailsDaoImpl.changePassword(newPassword, username);
		}
		
	}

	@Override
	public boolean userExists(String username) {
		// TODO Auto-generated method stub
		return false;
	}

}
