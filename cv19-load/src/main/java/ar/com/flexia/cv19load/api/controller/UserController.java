package ar.com.flexia.cv19load.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.flexia.cv19shared.api.dto.*;
import ar.com.flexia.cv19shared.model.entity.User;
import ar.com.flexia.cv19shared.service.*;


@RestController
@RequestMapping(path = "/user")
public class UserController {

	private UserService service;

	public UserController(UserService service) {
		super();
		this.service = service;
	}
	
	@PostMapping
	public User createUser(@RequestBody NewUser request) {
		return service.createUser(request);
	}
	
}