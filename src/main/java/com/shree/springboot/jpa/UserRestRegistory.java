package com.shree.springboot.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="users",path="users")
public interface UserRestRegistory extends PagingAndSortingRepository<User,Long> {
	
	List<User> findByUser(String user);
	
	List<User> findByRole(String role);

}
