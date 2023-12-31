package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Roles;

public interface RoleRepository extends JpaRepository<Roles, Integer>{
	Roles findById(int id);
}
