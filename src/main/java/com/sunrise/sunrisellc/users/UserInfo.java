package com.sunrise.sunrisellc.users;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "User_Details")
public class UserInfo {
	
	@Id
	@GeneratedValue(strategy= GenerationType.UUID)
	private UUID id;
	
	@Column(length = 255)
	private String name;
	
	@Column(length = 255)
	private String email;
	
	@Column(length = 255)
	private String password;
	
	@Column(length = 255)
	private String roles;

	

	public UserInfo(UUID id, String name, String email, String password, String roles) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public UserInfo() {
		super();
	
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setNane(String nane) {
		this.name = nane;
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
	
	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", roles="
				+ roles + "]";
	}

	
	
}
