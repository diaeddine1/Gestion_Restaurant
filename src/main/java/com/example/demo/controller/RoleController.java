package com.example.demo.controller;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.RoleServices;
import com.example.demo.entities.Roles;

@RestController
@RequestMapping("roles")
public class RoleController {
	
	
	private RoleServices roleServices;

	@PostMapping("/save")	
	public void save(@RequestBody Roles role) {
		roleServices.save(role);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Roles s = roleServices.findById(Integer.parseInt(id));
		roleServices.delete(s);}

	@GetMapping("/all")
	public List<Roles> findAll() {
		return roleServices.findAll();
	}

}
