package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.VilleServices;
import com.example.demo.entities.Ville;




@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("villes")
public class VilleController {
	@Autowired
	private VilleServices villeServices;

	@PostMapping("/save")	
	public void save(@RequestBody Ville ville) {
		villeServices.save(ville);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Ville s = villeServices.findById(Integer.parseInt(id));
		villeServices.delete(s);}

	@GetMapping("/all")
	public List<Ville> findAll() {
		return villeServices.findAll();
	}

	/*@GetMapping(value = "/count")
	public long countStudent() {
		return villeRepository.count();
	}*/


}
