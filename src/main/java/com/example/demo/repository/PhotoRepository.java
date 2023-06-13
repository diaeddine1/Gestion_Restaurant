package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Photo;


public interface PhotoRepository extends JpaRepository<Photo, Integer>{
	
	
	List<Photo> findAll();

	Photo findById(int id);
	//List<Photo> findByUserId(int userId);
}
