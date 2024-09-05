package com.mariamendes.workshopmongo.DTO;

import java.io.Serializable;

import com.mariamendes.workshopmongo.domain.User;

public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;

	public UserDTO() {

	}
	public UserDTO(User u) {

		id= u.getId();
		name =u.getName();
		email = u.getEmail();
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
