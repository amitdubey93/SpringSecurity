package org.h2o.service;

import java.util.ArrayList;

import org.h2o.dao.impl.UserDetailsDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDetailsDaoImpl userDetailsDaoImpl;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//do a bd call with the given username to check if user is present in the database or not.
		org.h2o.domain.UserDetails userDetails = userDetailsDaoImpl.findUserByUsername(username);
		System.out.println("userDetails:: "+userDetails);
		if(userDetails == null) {
			throw new UsernameNotFoundException("username not in db");
		}
		
		ArrayList<GrantedAuthority> authorities = new ArrayList<>();
		SimpleGrantedAuthority role1 = new SimpleGrantedAuthority("USER");
		authorities.add(role1);
		return new User(userDetails.getUsername(),userDetails.getPassword(),authorities);
		//can return custom user object which implements UserDetails
	}

}
