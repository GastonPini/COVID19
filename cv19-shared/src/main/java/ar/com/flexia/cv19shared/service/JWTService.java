package ar.com.flexia.cv19shared.service;

import com.auth0.jwt.interfaces.DecodedJWT;

import ar.com.flexia.cv19shared.model.entity.*;


public interface JWTService {
	
	String issueToken(User user);
	
	public DecodedJWT verify(String jwt);
	
}