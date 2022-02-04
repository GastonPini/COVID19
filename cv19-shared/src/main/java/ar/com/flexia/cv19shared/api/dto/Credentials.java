package ar.com.flexia.cv19shared.api.dto;

public class Credentials {

	private String username;
	
	private String password;
	
	public Credentials() {
		super();
	}

	public Credentials(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}