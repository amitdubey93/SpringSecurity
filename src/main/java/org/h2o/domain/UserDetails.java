package org.h2o.domain;

public class UserDetails {
	private String username;
	private String email;
	private String firstname;
	private String lastname;
	private String password;
	private String mobile;
	private String enabled;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "Customer [username=" + username + ", email=" + email + ", firstname=" + firstname + ", lastname="
				+ lastname + ", password=" + password + ", mobile=" + mobile + ", enabled=" + enabled + "]";
	}
	public UserDetails(String username, String email, String firstname, String lastname, String password, String mobile,
			String enabled) {
		super();
		this.username = username;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.mobile = mobile;
		this.enabled = enabled;
	}
	public UserDetails() {
	}
	

}
