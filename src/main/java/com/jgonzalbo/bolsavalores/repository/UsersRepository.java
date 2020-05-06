package com.jgonzalbo.bolsavalores.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jgonzalbo.bolsavalores.models.User;

public interface UsersRepository extends JpaRepository<User,Integer>{

}
