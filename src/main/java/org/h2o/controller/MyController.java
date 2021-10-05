package org.h2o.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Collection;

import org.h2o.dao.impl.SignUpDaoImpl;
import org.h2o.domian.SignUpDTO;

@Controller
public class MyController {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private SignUpDaoImpl signupDaoImpl;
	/*@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}*/
	
	
	@ResponseBody
	@RequestMapping("/admin")
	public String admin() {
		return "This url can be accessed by Admin";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Principal principle, Authentication auth, Model model) {
		String username = principle.getName();
		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
		System.out.println(username+" "+authorities);
		model.addAttribute("username", username);
		model.addAttribute("authorities", authorities);
		return "dashboard";
	}
	
	@ResponseBody
	@RequestMapping("/user")
	public String user() {
		return "This url can be accessed by User and Admin";
	}
	
	
	@ResponseBody
	@RequestMapping("/permitall")
	public String b() {
		return "This url can be accessed by everyone!!!";
	}
	
	@ResponseBody
	@RequestMapping("/denyall")
	public String denyall() {
		return "This url can't be accessed by anyone!!!";
	}
	
	
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/signup")
	public String signup(@ModelAttribute("signupdto") SignUpDTO signupdto) {
		return "signup";
	}
	
	@PostMapping("/process-signup")
	public String processSignup(SignUpDTO signUpDto) {
		
		signUpDto.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
		signupDaoImpl.saveUser(signUpDto);
		System.out.println(signUpDto);
		return "redirect:login";
	}
	
	@ResponseBody
	@RequestMapping("/accessdenied")
	public String accessdenied() {
		return "You're not authorized to see this page!!";
	}
	
	/*@RequestMapping("/logout")
	public String logout() {
		return "logout";
	}*/
}
