package com.example.myproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myproject.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
