package ar.com.flexia.cv19load.service.impl;

import javax.transaction.Transactional;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ar.com.flexia.cv19shared.api.dto.*;
import ar.com.flexia.cv19shared.model.entity.*;
import ar.com.flexia.cv19shared.service.*;
import ar.com.flexia.cv19shared.model.repository.*;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    
    private final PasswordEncoder passwordEncoder;
    
    private final JWTService jwtService;

    public UserServiceImpl(UserRepository repo, PasswordEncoder passwordEncoder, JWTService jwtService) {
    
    	this.repo = repo;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        
        User client = new User("client", this.passwordEncoder.encode("client"), UserProfile.CLIENT);
        this.repo.save(client);

    }
    
    @Transactional
	@Override
	public User createUser(NewUser newUser) {
		
		if(repo.findByUsername(newUser.getUsername()).isPresent())
			throw new IllegalArgumentException("El usuario " + newUser.getUsername() + " ya existe, ingrese otro nombre.");
		
		return repo.save(new User(newUser.getUsername(), newUser.getPassword(), UserProfile.CLIENT));
	}

    @Override
    public Session login(Credentials admin) {
        
    	User user = repo.findByUsername(admin.getUsername())
                .orElseThrow(() -> new BadCredentialsException("Credenciales inválidas"));
        
    	if (!passwordEncoder.matches(admin.getPassword(), user.getPassword()))
            throw new BadCredentialsException("Credenciales inválidas");
        
    	String token = jwtService.issueToken(user);
        return new Session(token, user);
        
    }
    
}