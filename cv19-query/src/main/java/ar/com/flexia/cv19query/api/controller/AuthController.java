package ar.com.flexia.cv19query.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.flexia.cv19shared.api.dto.*;
import ar.com.flexia.cv19shared.service.UserService;


@RestController
@RequestMapping(path = "/auth")
public class AuthController {

	private UserService service;
	
	public AuthController(UserService service) {
		super();
		this.service = service;
	}

	@PostMapping(path = "/login")
	public Session login(@RequestBody Credentials creds) {
		return service.login(creds);
	}
	
}