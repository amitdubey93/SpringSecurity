package org.h2o.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Collection;

import org.h2o.dao.impl.SignUpDaoImpl;
import org.h2o.domain.ChangePasswordDTO;
import org.h2o.domain.SignUpDTO;

@Controller
public class MyController {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JdbcUserDetailsManager jdbcUserDetailsManager;
	
	
	@Autowired
	private SignUpDaoImpl signupDaoImpl;
	/*@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}*/
	
	
	@RequestMapping("/admin")
	public String admin(Principal principle, Model model) {
		String username = principle.getName();
		model.addAttribute("username", username);
		return "admin-dashboard";
	}
	
	@GetMapping("/user-dashboard")
	public String dashboard(Principal principle, Authentication auth, Model model) {
		String username = principle.getName();
		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
		System.out.println(username+" "+authorities);
		model.addAttribute("username", username);
		model.addAttribute("authorities", authorities);
		return "user-dashboard";
	}
	
	@RequestMapping("/user")
	public String user() {
		return "redirect:/user-dashboard";
	}
	
	
	@RequestMapping({"/","/home"})
	public String home() {
		return "home";
	}
	
	@ResponseBody
	@RequestMapping("/denyall")
	public String denyall() {
		return "404";
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
		//signupDaoImpl.saveUser(signUpDto);
		UserDetails user = User.withUsername(signUpDto.getUsername()).password(signUpDto.getPassword()).authorities("USER").build();
		jdbcUserDetailsManager.createUser(user);
		
		System.out.println(signUpDto);
		return "redirect:login";
	}
	
	@GetMapping("/change-password")
	public String changePassword(Model model) {
		model.addAttribute("cpdto", new ChangePasswordDTO());
		return "change-password";
	}
	
	@PostMapping("/process-change-password")
	public String processChangePassword(Principal principal, ChangePasswordDTO cpdto) {
		String newEncodedPassword = passwordEncoder.encode(cpdto.getNewPassword());
		UserDetails user = jdbcUserDetailsManager.loadUserByUsername(principal.getName());
		boolean matches = passwordEncoder.matches(cpdto.getOldPassword(), user.getPassword());
		
		//if newpassword and confirmpassword matches
		if(!cpdto.getNewPassword().equals(cpdto.getConfirmPassword())) {
			return "redirect:change-password?error=password mismatch";
		}
		//if users password matches with database
		if(matches) {
			jdbcUserDetailsManager.changePassword(cpdto.getOldPassword(), newEncodedPassword);
			return "redirect:login";
		}
		return "redirect:change-password?error=Old password is not correct!!";
	}
	
	//changePassword
	@GetMapping("/deleteUser{username}")
	public String deleteUser(@RequestParam String username) {
		jdbcUserDetailsManager.deleteUser(username);
		return "redirect:/home";
	}
	
	@RequestMapping("/accessdenied")
	public String accessdenied() {
		return "404";
	}
	
	/*@RequestMapping("/logout")
	public String logout() {
		return "logout";
	}*/
}
