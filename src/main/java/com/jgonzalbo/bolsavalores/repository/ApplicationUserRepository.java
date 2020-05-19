package com.jgonzalbo.bolsavalores.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jgonzalbo.bolsavalores.models.users.ApplicationUser;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser,Integer>{
	
	public Optional<ApplicationUser> findByUsername(String username);
	public Optional<ApplicationUser> findByEmail(String email);

}
