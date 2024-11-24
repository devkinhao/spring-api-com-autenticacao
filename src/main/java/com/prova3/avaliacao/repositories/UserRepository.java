package com.prova3.avaliacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.prova3.avaliacao.user.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	UserDetails findByLogin(String login);

}
