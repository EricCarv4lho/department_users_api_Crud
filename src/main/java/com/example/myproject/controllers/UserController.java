package com.example.myproject.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myproject.entities.User;
import com.example.myproject.repositories.UserRepository;

@RequestMapping(value = "/users")
@RestController

public class UserController {
	@Autowired
	
	UserRepository repository;
	
	@GetMapping
	public List<User> findAll(){
		return repository.findAll();
	 
		
	}
	
	@GetMapping(value = "/{id}")
	public User findOne(@PathVariable Long id) {
		return repository.findById(id).get();
	
	
	}
	
	@PutMapping
	public User update(@RequestBody User user) {
		return repository.save(user);
	
	
	}
	
	
	@PostMapping
	public User create(@RequestBody User user) {
		return repository.save(user);
	
	}
	
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Long id) {
	    repository.deleteById(id);
	    
	    
	    	
			
		
	    
	    
	}
	
	
	
	
	
	
	

	}
	
	

