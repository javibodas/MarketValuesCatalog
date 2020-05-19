package com.jgonzalbo.bolsavalores.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jgonzalbo.bolsavalores.models.users.ApplicationUser;
import com.jgonzalbo.bolsavalores.service.IApplicationUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private static final Logger logger = LogManager.getLogger(UserController.class);
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private IApplicationUserService userService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<ApplicationUser>> getUsers() {
		logger.log(Level.INFO, "GET /user");
		
		return new ResponseEntity<>(userService.getAllUsers(),  HttpStatus.OK);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST, consumes="application/json", produces="application/json")
	@ResponseBody
	public HashMap<String,Object> createUser(@RequestBody ApplicationUser user) {
		logger.log(Level.INFO, "POST /user");
		
		return userService.createUser(user);
	}
	
	@RequestMapping(value = "", method = RequestMethod.PUT, consumes="application/json", produces="application/json")
	@ResponseBody
	public HashMap<String,Object> updateUser(@RequestBody ApplicationUser user) {
		logger.log(Level.INFO, "PUT /user");
		
		return userService.updateUser(user);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET, produces="application/json")
	@ResponseBody
	public ResponseEntity<List<ApplicationUser>> getUser(@PathVariable int id) {
		logger.log(Level.INFO, "GET /user/{" + id + "}");
		
		return new ResponseEntity<>(userService.getAllUsers(),  HttpStatus.OK);
	}
	
	@RequestMapping(value="/encrypted/{password}", method = RequestMethod.GET, produces="application/json")
	@ResponseBody
	public String getEncrypted(@PathVariable String password) {
		logger.log(Level.INFO, "GET /encrypted/{" + password + "}");
		
		String encodedPass = passwordEncoder.encode(password);
		return encodedPass;
	}
	
	@RequestMapping(value="/authenticated", method = RequestMethod.GET, produces="application/json")
	@ResponseBody
	public ApplicationUser getAuthenticatedUser(Authentication auth) {
		logger.log(Level.INFO, "GET /user/authenticated");
		
		ApplicationUser us = userService.getUserByUsername((String) auth.getPrincipal());
		us.setPassword(null);
		return us;
	}
	
	@ModelAttribute
	public void setResponseHeader(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
	}
	
}
