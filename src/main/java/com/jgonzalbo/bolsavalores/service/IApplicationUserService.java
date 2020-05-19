package com.jgonzalbo.bolsavalores.service;

import java.util.List;

import com.jgonzalbo.bolsavalores.models.users.ApplicationUser;

public interface IApplicationUserService {
	
	public List<ApplicationUser> getAllUsers();
	public ApplicationUser getUserById(int id);
	public void savesOrUpdateUser(ApplicationUser u);
	public ApplicationUser getUserByUsername(String username);

}
