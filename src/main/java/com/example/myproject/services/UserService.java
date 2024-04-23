package com.example.myproject.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myproject.entities.User;
import com.example.myproject.repositories.UserRepository;



@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	 

	
	@Autowired
	public UserService(UserRepository userRepository) {
		
		this.userRepository = userRepository;
	}
	
	

	public List<User> findAll(){
		try {
			return userRepository.findAll();
			
		} catch (Exception e) {
			throw new RuntimeException("Erro ao buscar usuários:  " + e.getMessage());
			// TODO: handle exception
		}
		
	}
	
	public User findOne(Long id){
		
		try {
			return userRepository.findById(id).orElse(null);
		} catch (Exception e) {
			throw new RuntimeException("Erro ao buscar usuário: " + e.getMessage());
			// TODO: handle exception
		}
		
	}
	
	public User create( User user) {
		
		try {
			return userRepository.save(user);
			
		} catch (Exception e) {
			throw new RuntimeException("Erro ao criar usuário: " + e.getMessage());
			// TODO: handle exception
		}
		
	}

	public User findAndUpdate(User user) {
		try {
			return userRepository.save(user);
			
		} catch (Exception e) {
			throw new RuntimeException("Erro ao buscar usuário: " + e.getMessage());
			// TODO: handle exception
		}
		
	}
	
	public void findAndDelete(Long id) {
		try { userRepository.deleteById(id);
			
		} catch (Exception e) {
			throw new RuntimeException("Erro ao buscar usuário: " + e.getMessage());
			// TODO: handle exception
		}
		
	
	
	
	


	}
}
