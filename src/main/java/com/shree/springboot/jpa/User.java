package com.shree.springboot.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String user;
	
	private String role;
	
	
	
	private User() {
		
	}
	
	
	public User(String user, String role) {
		super();
		this.user = user;
		this.role = role;
	}

	

	@Override
	public String toString() {
		return "User [id=" + id + ", user=" + user + ", role=" + role + "]";
	}


	public Long getId() {
		return id;
	}
	public String getUser() {
		return user;
	}
	public String getRole() {
		return role;
	}
	
	
}
