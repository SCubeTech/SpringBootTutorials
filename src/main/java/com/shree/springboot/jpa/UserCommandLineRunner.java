package com.shree.springboot.jpa;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCommandLineRunner implements CommandLineRunner{
	
	private static final Logger log  = LoggerFactory.getLogger(UserCommandLineRunner.class);
	

	@Autowired
	UserRegistory repository;
	
	@Override
	public void run(String... arg0) throws Exception {
		
		System.out.println("Inside spring boot command line runner");
		
		//repository.save(new User("Sri","Admin"));
		//repository.save(new User("Sri1","Admin"));
		//repository.save(new User("Shree","Admin"));
		//repository.save(new User("Sri211","User"));
		
		//repository.delete(1L);
		
//		System.out.println(repository.count());
//		
//		repository.findByUser("Sri1").forEach((user)->log.info(user.toString()));
//		
//		repository.findAll().forEach((user)->log.info(user.toString()));
//		
//		log.info("Printing all users with Role of Admin");
//		
//		repository.findByRole("Admin").forEach((user)->log.info(user.toString()));
	}

}
