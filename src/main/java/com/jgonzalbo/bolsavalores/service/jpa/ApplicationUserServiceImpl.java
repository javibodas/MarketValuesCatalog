package com.jgonzalbo.bolsavalores.service.jpa;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jgonzalbo.bolsavalores.models.users.ApplicationUser;
import com.jgonzalbo.bolsavalores.repository.ApplicationUserRepository;
import com.jgonzalbo.bolsavalores.service.IApplicationUserService;

@Service
public class ApplicationUserServiceImpl implements IApplicationUserService{
	
	@Autowired
	private ApplicationUserRepository usersRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public List<ApplicationUser> getAllUsers() {
		// TODO Auto-generated method stub
		return usersRepository.findAll();
	}
	
	@Override
	public void savesOrUpdateUser(ApplicationUser user) {
		String encryptPass = passwordEncoder.encode(user.getPassword());
		user.setPassword(encryptPass);
		
		/*if(usersRepository.findByEmail(user.getEmail())){
			usersRepository.
		}*/
		
		user.setCreateDate(LocalDate.now());
		// It is possible to start user at status 0 and depends on confirm an email to activate it with spring-boot-starter-mail
		user.setStatus(1);
		usersRepository.save(user);
	}
	
	@Override
	public ApplicationUser getUserById(int id) {
		return usersRepository.findById(id).get();
	}
	
	@Override
	public ApplicationUser getUserByUsername(String username) {
		return usersRepository.findByUsername(username);
	}

}
