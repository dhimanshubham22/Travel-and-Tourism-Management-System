package com.system.toursandtravelmanagement.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserRegisteredDTO {
	@NotBlank(message = "Name is required")
	 private String name;
	 @NotBlank(message = "Email is required")
	    @Email(message = "Invalid email format")
	 private String email_id;
	
	private String password;
	
	private String role;
	
	public UserRegisteredDTO() {
		super();
	}

	public UserRegisteredDTO(String role) {
		super();
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPassword() {
		return password;
	}

	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
