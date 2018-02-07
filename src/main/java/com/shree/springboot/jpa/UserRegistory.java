package com.shree.springboot.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRegistory extends CrudRepository<User,Long> {
	
	List<User> findByUser(@Param("user") String user);
	
	List<User> findByRole(@Param("role") String role);

}
