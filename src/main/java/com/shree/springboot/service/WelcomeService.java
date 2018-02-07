package com.shree.springboot.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class WelcomeService {

	public List retreiveWelcomeMessage() {
		List welcome = new ArrayList();
		welcome.add(1);
		welcome.add(2);
		welcome.add(3);
		
		List welcome2 = new ArrayList();
		welcome2.add(1);
		welcome2.add(2);
		welcome2.add(3);
		
		List welcome3 = new ArrayList();
		welcome3.add(welcome);
		welcome3.add(welcome2);
		
		return (welcome3);
	}
}
