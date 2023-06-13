package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findById(int id);
	User findByEmailAndPassword(String email, String password);
	
}
