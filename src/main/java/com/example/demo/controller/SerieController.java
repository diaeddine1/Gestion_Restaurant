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

import com.example.demo.Services.SerieServices;
import com.example.demo.entities.Serie;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("series")
public class SerieController {
	
	@Autowired
	private SerieServices serieServices;

	@PostMapping("/save")	
	public void save(@RequestBody Serie serie) {
		serieServices.save(serie);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Serie s = serieServices.findById(Integer.parseInt(id));
		serieServices.delete(s);}

	@GetMapping("/all")
	public List<Serie> findAll() {
		return serieServices.findAll();
	}

}
