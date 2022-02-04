package ar.com.flexia.cv19shared.service;

import ar.com.flexia.cv19shared.api.dto.*;
import ar.com.flexia.cv19shared.model.entity.User;


public interface UserService {

    Session login(Credentials userCredentials);

	User createUser(NewUser newUser);
	
}