package ar.com.flexia.cv19shared.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(
	name = "users",
	uniqueConstraints = { 
		@UniqueConstraint( name = "UC_USERNAME", columnNames = { "username" } )
	}
)
public class User implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
    private Long id;

    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserProfile profile;

    public User() {}

    public User(String username, String password, UserProfile profile) {
        this.username = username;
        this.password = password;
        this.profile = profile;
    }

    public Long getId() {
        return id;
    }
    
    public String getUsername() {
        return username;
    }

    public UserProfile getProfile() {
        return profile;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority(this.profile.name()));
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	@JsonIgnore
	public boolean isEnabled() {
		return false;
	}

}