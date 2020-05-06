package com.jgonzalbo.bolsavalores.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jgonzalbo.bolsavalores.models.User;
import com.jgonzalbo.bolsavalores.repository.UsersRepository;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private UsersRepository usersRepository;

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return usersRepository.findAll();
	}

}
