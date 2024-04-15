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
		return userRepository.findAll();
	}
	
	public User findOne(Long id){
		return userRepository.findById(id).orElse(null);
	}
	
	public User create( User user) {
		return userRepository.save(user);
	}

	public User findAndUpdate(User user) {
		return userRepository.save(user);
	}
	
	public void findAndDelete(Long id) {
		 userRepository.deleteById(id);
	
	
	
	


	}
}
