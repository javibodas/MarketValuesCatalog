package com.jgonzalbo.bolsavalores.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jgonzalbo.bolsavalores.models.users.ApplicationUser;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser,Integer>{
	
	public ApplicationUser findByUsername(String username);

}
