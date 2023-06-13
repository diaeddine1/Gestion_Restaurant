package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Reservation;


public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
	
	Reservation findById(int id);
	List<Reservation> findByUserId(int userId);
}
