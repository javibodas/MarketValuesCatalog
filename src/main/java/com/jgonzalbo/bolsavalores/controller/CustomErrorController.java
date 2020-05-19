package com.jgonzalbo.bolsavalores.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Controller
public class CustomErrorController implements ErrorController {
 
	private static final Logger logger = LogManager.getLogger(CustomErrorController.class);
 
	/* @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
    	logger.log(Level.ERROR, request.getMethod() + " " + request.getRequestURI() + " - " + request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));
    	
    	if (HttpStatus.NOT_FOUND
                .value() == (int) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE)) {
            return "redirect:/";
        }
        
        if (HttpStatus.NOT_FOUND
                .value() == (int) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE)) {
            return "redirect:/";
        }
          
        return "redirect:/";
    }*/
 
    @Override
    public String getErrorPath() {
        return "/error";
    }
 
}
