package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{
	Restaurant findById(int id);
}
