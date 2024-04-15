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

import io.swagger.v3.oas.annotations.Operation;

@RequestMapping(value = "/users")
@RestController

public class UserController {
	@Autowired
	
	UserRepository repository;
	
	@Operation(summary = "Listar", description = "Este método lista todos os usuários.")
	
	@GetMapping
	 public List<User> findAll(){
	return repository.findAll();
	
	 
		
	}
	@Operation(summary = "Listar um usuário", description = "Este método retorna apenas um usuário.")
	
	@GetMapping(value = "/{id}")
	public User findOne(@PathVariable Long id) {
		return repository.findById(id).get();
	
	
	}
	@Operation(summary = "Atualizar informação", description = "Este método atualiza as informações de um usuário.")
	@PutMapping
	public User update(@RequestBody User user) {
		return repository.save(user);
	
	
	}
	
	@Operation(summary = "Criar usuário", description = "Este método cria um usuário.")
	@PostMapping
	public User create(@RequestBody User user) {
		return repository.save(user);
	
	}
	
	@Operation(summary = "Deletar usuário", description = "Este método deleta apenas um usuário")
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Long id) {
	    repository.deleteById(id);
	    
	    
	    	
			
		
	    
	    
	}
	
	
	
	
	
	
	

	}
	
	

