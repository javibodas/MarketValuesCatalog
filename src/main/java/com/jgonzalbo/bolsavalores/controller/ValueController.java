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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jgonzalbo.bolsavalores.models.Value;
import com.jgonzalbo.bolsavalores.service.IValueService;

@Controller
@RequestMapping("/values")
public class ValueController {
	
	private static final Logger logger = LogManager.getLogger(ValueController.class);
	
	@Autowired
	private IValueService valueService;
	
	@GetMapping("/{id}")
	public String get_value(@PathVariable("id") String id, Model model) {
		return "value";
	}
	
	@GetMapping("/search")
	@ResponseBody
	public ResponseEntity<List<Value>> searchValue(@RequestParam("value") String value, @RequestParam("country") String countries, @RequestParam("stock") String stock) {
		logger.log(Level.INFO, "GET /values/search?value=" + value + "&country=" + countries + "&" + stock);
		
		Object[] lists = valueService.search(value, stock, countries);
		return new ResponseEntity<List<Value>>((List<Value>)lists[0], HttpStatus.OK);
	}
	
	@ModelAttribute
	public void setResponseHeader(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
	}

}
