package org.h2o.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//this class is going to help you to create spring security filter chain.
@EnableWebSecurity(debug = false)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private PasswordEncoder bcryptPasswordEncoder;
	
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
//		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(NoOpPasswordEncoder.getInstance());
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(bcryptPasswordEncoder);
		
		
//		auth.inMemoryAuthentication().withUser("admin1").password(bcryptPasswordEncoder.encode("admin1")).roles("admin");
//		auth.inMemoryAuthentication().withUser("user1").password(bcryptPasswordEncoder.encode("user1")).roles("user");

//		auth.inMemoryAuthentication().withUser("amit")
//				.password("{bcrypt}$2a$10$jz.xLS8euXRlD4AFV5xFcuarSq8dIPT2r49DTGBe8Cuauy1lOPQMe").roles("admin");
//		auth.inMemoryAuthentication().withUser("amit1")
//				.password("{bcrypt}$2a$10$BB5DTnHhST..0.NIMvT0OetTAWG6N1nehtGv/c9luquw.u3sizRcK").roles("admin");

		// System.out.println(bcryptPasswordEncoder.encode("12345"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/user").hasAuthority("USER")
		.antMatchers("/admin").hasAuthority("ADMIN")
		.antMatchers("/permitall").permitAll()
		.antMatchers("/denyall").denyAll()
		.and().formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/user-dashboard", true)
		.and().httpBasic()
		.and().logout().logoutSuccessUrl("/login?logout").invalidateHttpSession(true).deleteCookies("JSESSIONID").permitAll()
		.and().exceptionHandling().accessDeniedPage("/accessdenied");	
			
	}
	

}
