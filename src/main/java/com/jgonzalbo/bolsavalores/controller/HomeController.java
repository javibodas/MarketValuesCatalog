package com.jgonzalbo.bolsavalores.controller;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	private static final Logger logger = LogManager.getLogger(HomeController.class);
	
	@GetMapping("/")
	public String getHome(Model model) {
		logger.log(Level.INFO, "GET /");
		
		return "index";
	}
}
