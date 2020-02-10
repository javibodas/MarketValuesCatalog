package com.jgonzalbo.bolsavalores.controller;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jgonzalbo.bolsavalores.models.Value;

@Controller
public class RootController {
	
	@GetMapping("/")
	public String get_root(Model model) {
		
		JSONParser parser = new JSONParser("{\"symbol\":\"T\",\"name\":\"AT&T Inc.\",\"currency\":\"USD\",\"price\":\"38.50\",\"price_open\":\"38.60\",\"day_high\":\"38.78\",\"day_low\":\"38.23\",\"52_week_high\":\"39.70\",\"52_week_low\":\"28.92\",\"day_change\":\"-0.13\",\"change_pct\":\"-0.34\",\"close_yesterday\":\"38.63\",\"market_cap\":\"281242501120\",\"volume\":\"30633769\",\"volume_avg\":\"31773085\",\"shares\":\"7304999936\",\"stock_exchange_long\":\"New York Stock Exchange\",\"stock_exchange_short\":\"NYSE\",\"timezone\":\"EST\",\"timezone_name\":\"America/New_York\",\"gmt_offset\":\"-18000\",\"last_trade_time\":\"2020-01-24 16:05:29\",\"pe\":\"17.26\",\"eps\":\"2.23\"}");
		List<Value> values = new LinkedList<>();
		
		try {
			LinkedHashMap<String,Object> json = parser.object();
			
			Value v = new Value();
			v.setName((String)json.get("name"));
			v.setCurrency((String)json.get("currency"));
			v.setPrice((String)json.get("price"));
			v.setDay_change((String)json.get("day_change"));
			v.setPe((String)json.get("pe"));
			v.setEps((String)json.get("eps"));
			v.setShares((String)json.get("shares"));
			values.add(v);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		model.addAttribute("values", values);
		return "root";
	}
	
	@PostMapping("/search")
	public void search_value(@RequestParam("value") String value) {
		// TO-DO
		System.out.println(value);
	}


}
