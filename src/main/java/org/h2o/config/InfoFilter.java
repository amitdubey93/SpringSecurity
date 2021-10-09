package org.h2o.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class InfoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		Authentication currentUser = SecurityContextHolder.getContext()
				.getAuthentication();
		
//		System.out.println("currentUser.getPrincipal: "+currentUser.getPrincipal());
//		System.out.println("currentUser.getName: "+currentUser.getName());
//		System.out.println("currentUser.getAuthorities: "+currentUser.getAuthorities());
//		System.out.println("currentUser.getClass: "+currentUser.getClass());
//		System.out.println("currentUser.getCredentials: "+currentUser.getCredentials().toString());
//		System.out.println("currentUser.getDetails: "+currentUser.getDetails());
//		System.out.println("currentUser.isAuthenticated: "+currentUser.isAuthenticated());
		try {
			System.out.println("currentUser.isAuthenticated: "+currentUser.isAuthenticated());
			System.out.println("currentUser.getCredentials: "+currentUser.getCredentials());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		chain.doFilter(request, response);
	}

}
