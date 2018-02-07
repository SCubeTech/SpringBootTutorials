package com.shree.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shree.springboot.configuration.BasicConfiguration;
import com.shree.springboot.service.WelcomeService;

@RestController
public class WelcomeController {
	
	@Autowired
	WelcomeService service;
	
	@Autowired
	BasicConfiguration configuration;
	
	@Value("${welcome.message}")
	String messge;
	

	 @GetMapping("/welcome")
	public List welcome() {
		return service.retreiveWelcomeMessage();
	}
	 
	 @GetMapping("/welcome1")
		public String welcome1() {
			return messge;
		}
	 
	 @GetMapping("/config")
		public Map config() {
		 Map map = new HashMap<>();
		 
		 map.put("message", configuration.getMessage());
		 map.put("id", configuration.getId());
		 map.put("success", configuration.isSuccess());
		 
			return map;
		}
	 
	
}
