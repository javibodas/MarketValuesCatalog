package com.jgonzalbo.bolsavalores.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jgonzalbo.bolsavalores.models.Index;
import com.jgonzalbo.bolsavalores.service.IIndexService;

@Controller
@RequestMapping("/index")
public class IndexController {
	
	private static final Logger logger = LogManager.getLogger(IndexController.class);
	
	@Autowired
	private IIndexService indexService;
	
	@GetMapping("")
	@ResponseBody
	public  ResponseEntity<List<Index>> getAllIndex(){
		logger.log(Level.INFO, "GET /index");
		
		return new ResponseEntity<List<Index>>(indexService.getAllStocks(), HttpStatus.OK);
	}
	
	@ModelAttribute
	public void setResponseHeader(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
	}

}
