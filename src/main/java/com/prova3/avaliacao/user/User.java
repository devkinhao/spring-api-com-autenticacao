package com.prova3.avaliacao.user;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "users")
@Entity
public class User implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	private String login;
	private String password;
	private UserRole role;
	
	public User() {
	}
	
	public User(String login, String password, UserRole role) {
		this.login = login;
		this.password = password;
		this.role = role;
	}
	
	public User(String id, String login, String password, UserRole role) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	
	public String getPassword() {
		return password;
	}

	public UserRole getRole() {
		return role;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(this.role == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
		else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getUsername() {
		return login;
	}

	
	
	

	
	
	
	



}
