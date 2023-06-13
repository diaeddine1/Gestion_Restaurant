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

import com.example.demo.Services.ZoneServices;
import com.example.demo.entities.Zone;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("zones")
public class ZoneController {
	@Autowired
	private ZoneServices zoneServices;

	@PostMapping("/save")
	public void save(@RequestBody Zone zone) {
		zoneServices.save(zone);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Zone s = zoneServices.findById(Integer.parseInt(id));
		zoneServices.delete(s);}

	@GetMapping("/all")
	public List<Zone> findAll() {
		return zoneServices.findAll();
	}
}
