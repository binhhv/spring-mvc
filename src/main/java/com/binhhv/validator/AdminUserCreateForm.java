package com.binhhv.validator;

import org.hibernate.validator.constraints.NotEmpty;

public class AdminUserCreateForm {

	@NotEmpty
	private String username="";
	@NotEmpty
	private String email="";
	@NotEmpty
	private String password="";
	
	private String listRole[];

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String[] getListRole() {
		return listRole;
	}

	public void setListRole(String[] listRole) {
		this.listRole = listRole;
	}

	public AdminUserCreateForm(String username, String email, String password,
			String[] listRole) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.listRole = listRole;
	}

	public AdminUserCreateForm() {
		super();
	}
	
	
}
