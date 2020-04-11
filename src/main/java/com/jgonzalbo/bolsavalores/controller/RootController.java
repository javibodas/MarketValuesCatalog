package com.jgonzalbo.bolsavalores.controller;

import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jgonzalbo.bolsavalores.models.Stock;
import com.jgonzalbo.bolsavalores.models.Value;
import com.jgonzalbo.bolsavalores.service.IStockService;
import com.jgonzalbo.bolsavalores.service.IValueService;

@Controller
public class RootController {
	
	private static final Logger logger = LogManager.getLogger(RootController.class);
	
	@Autowired
	private IStockService stockService;
	
	@Autowired
	private IValueService valueService;
	
	@GetMapping("/")
	public String getHome(Model model) {
		
		logger.log(Level.INFO, "GET /");
		
		model.addAttribute("stocks", stockService.getAllStocks());
		return "index";
	}
	
	@PostMapping("/search")
	public String searchValue(Model model, @RequestParam("value") String value, @RequestParam("country") String countries, @RequestParam("stock") String stock) {
		
		logger.log(Level.INFO, "POST /search?value=" + value + "&country=" + countries + "&" + stock);
		
		Object[] lists = valueService.search(value, stock, countries);
		model.addAttribute("stocks", (List<Stock>)lists[1]);
		model.addAttribute("values", (List<Value>)lists[0]);
		return "index";
	}


}
