package com.jgonzalbo.bolsavalores.service;

import java.util.HashMap;
import java.util.List;

import com.jgonzalbo.bolsavalores.models.users.ApplicationUser;

public interface IApplicationUserService {
	
	public List<ApplicationUser> getAllUsers();
	public ApplicationUser getUserById(int id);
	public HashMap<String,Object> createUser(ApplicationUser u);
	public HashMap<String,Object> updateUser(ApplicationUser u);
	public ApplicationUser getUserByUsername(String username);
	public HashMap<String,Object> deleteUser(int id);

}
