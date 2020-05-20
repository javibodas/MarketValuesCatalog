package com.jgonzalbo.bolsavalores.service.jpa;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jgonzalbo.bolsavalores.models.users.ApplicationUser;
import com.jgonzalbo.bolsavalores.models.users.ApplicationUserRole;
import com.jgonzalbo.bolsavalores.repository.ApplicationUserRepository;
import com.jgonzalbo.bolsavalores.service.IApplicationUserService;

@Service
public class ApplicationUserServiceImpl implements IApplicationUserService{
	
	private static final Logger logger = LogManager.getLogger(ApplicationUserServiceImpl.class);
	
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
	public HashMap<String,Object> createUser(ApplicationUser user) {
		
		HashMap<String,Object> result = new HashMap<>();
			
		// Create User
		if(user.getObjid() == 0) {
			if(usersRepository.findByEmail(user.getEmail()).isPresent()){
				result.put("result", false);
				result.put("message", "Already exist an user with that email");
				return result;
			}
			
			if(getUserByUsername(user.getUsername()) != null){
				result.put("result", false);
				result.put("message", "Already exist an user with that username");
				return result;
			}
			
			logger.log(Level.INFO, "CREATE USER - Username: " + user.getUsername() + " - Email:" + user.getEmail() + " - Role: " + ApplicationUserRole.USER_ROLE);
			String encryptPass = passwordEncoder.encode(user.getPassword());
			user.setPassword(encryptPass);
			user.setCreateDate(LocalDate.now());
			// It is possible to start user at status 0 and depends on confirm an email to activate it with spring-boot-starter-mail
			user.setStatus(1);
			
			ApplicationUserRole r = new ApplicationUserRole();
			r.setObjid(ApplicationUserRole.USER_ROLE);
			user.getRoles().add(r);
			
			usersRepository.save(user);
			result.put("result", true);
			return result;
		}
		
		result.put("result", false);
		result.put("message", "User already exists. Try method PUT.");
		return result;

	}
	
	@Override
	public HashMap<String,Object> updateUser(ApplicationUser user) {
		
		HashMap<String,Object> result = new HashMap<>();
		ApplicationUser actUser = getUserById(user.getObjid());
		
		if(actUser == null){
			result.put("result", false);
			result.put("message", "User does not exist");
			return result;
		}
		
		if(user.getPassword() != null) {
			actUser.setPassword(passwordEncoder.encode(user.getPassword()));
		}
		
		if(user.getEmail() != null && !user.getEmail().equals(actUser.getEmail())) {
			if(usersRepository.findByEmail(actUser.getEmail()).isPresent()){
				result.put("result", false);
				result.put("message", "Already exist an user with that email");
				return result;
			}
			actUser.setEmail(user.getEmail());
		}
		
		usersRepository.save(actUser);
		result.put("result", true);
		
		return result;
	}
	
	@Override
	public HashMap<String,Object> deleteUser(int id){
		HashMap<String,Object> result = new HashMap<>();
		ApplicationUser u = getUserById(id);
		
		if(u == null) {
			result.put("result", false);
			result.put("message", "User does not exist");
		}
		
		usersRepository.delete(u);
		result.put("result", true);
		return result;
	}
	
	@Override
	public ApplicationUser getUserById(int id) {
		return usersRepository.findById(id).isPresent() ? usersRepository.findById(id).get() : null;
	}
	
	@Override
	public ApplicationUser getUserByUsername(String username) {
		return usersRepository.findByUsername(username).isPresent() ? usersRepository.findByUsername(username).get() : null;
	}

}
