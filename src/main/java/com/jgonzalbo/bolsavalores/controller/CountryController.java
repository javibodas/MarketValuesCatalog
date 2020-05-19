package com.jgonzalbo.bolsavalores.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jgonzalbo.bolsavalores.models.Country;
import com.jgonzalbo.bolsavalores.service.ICountryService;

@RestController
@RequestMapping("/country")
public class CountryController {
	
	private static final Logger logger = LogManager.getLogger(UserController.class);
	
	
	@Autowired
	private ICountryService countryService;
	
	@RequestMapping(value="", produces="application/json")
	@ResponseBody
	public List<Country> getCountries() {
		logger.log(Level.INFO, "GET /country");
		return countryService.getAllCountries();
		
	}
	
	@ModelAttribute
	public void setResponseHeader(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
	}

}
