package com.example.myproject.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myproject.entities.User;
import com.example.myproject.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;

import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping(value = "/users")
@RestController

public class UserController {
	
	private final UserService userService;
	
	
	


	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	@Operation(summary = "Listar", description = "Este método lista todos os usuários.")
	@GetMapping
	public ResponseEntity <List<User>> findAll(){
		
		
		try {List<User> listUsers = userService.findAll();
		 return ResponseEntity.ok().body(listUsers);}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			// TODO: handle exception
		}
		
		 
	}
		
	 
	@Operation(summary = "Listar um usuário", description = "Este método retorna apenas um usuário.")
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findOne(@PathVariable Long id){
		
		try {
		User oneUser = userService.findOne(id);
		return ResponseEntity.ok().body(oneUser);
		}
		
		
		
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			// TODO: handle exception
		}
				
	}
	
	
	
	
	@Operation(summary = "Atualizar informação", description = "Este método atualiza as informações de um usuário.")
	@PutMapping
	
	public ResponseEntity<User> Update(@RequestBody User user) {
		try {
			User updatedUser = userService.findAndUpdate(user);
			return ResponseEntity.ok().body(updatedUser);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			// TODO: handle exception
		}
		
		
	}
	
	@Operation(summary = "Criar usuário", description = "Este método cria um usuário.")
	@PostMapping
	public ResponseEntity<User> create(@RequestBody @Valid User user) {
		try {
		User novoUsuario = userService.create(user);
		return new ResponseEntity<>(user,HttpStatus.CREATED);}
		
		catch (ValidationException e) {
			return ResponseEntity.badRequest().build();
			// TODO: handle exception
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			// TODO: handle exception
		}
		
	}
	
	@Operation(summary = "Deletar usuário", description = "Este método deleta apenas um usuário")
	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
	    try {
	        userService.findAndDelete(id);
	        return ResponseEntity.noContent().build(); // Exclusão bem-sucedida, sem conteúdo para retornar
	    } catch (EntityNotFoundException e) {
	        return ResponseEntity.notFound().build(); // Usuário não encontrado com o ID fornecido
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Erro interno do servidor
	    }
	}
	
	
}
	
	

