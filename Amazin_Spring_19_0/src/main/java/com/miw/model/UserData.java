package com.miw.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class UserData {

	@NotEmpty
	private String username;
	
	@Length(min = 1, max = 8, message = "Debe tener entre 1 y 8 caracteres.")
	private String password;
	
	@Length(min = 1, max = 8, message = "Debe tener entre 1 y 8 caracteres.")
	private String repassword;
	
	@NotEmpty
	@Email
	private String email;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
