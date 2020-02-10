package com.jgonzalbo.bolsavalores.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/values")
public class ValueController {
	
	@GetMapping("/{id}")
	public String get_value(@PathVariable("id") String id, Model model) {
		return "value";
	}

}
