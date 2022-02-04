package ar.com.flexia.cv19shared.api.dto;

import ar.com.flexia.cv19shared.model.entity.*;

public class Session {

	private String token;
	
	private User user;

	public Session(String token, User user) {
		super();
		this.token = token;
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public User getUser() {
		return user;
	}

}