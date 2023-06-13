package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToMany;


@Entity
public class Specialite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	
	@ManyToMany
	private List<Restaurant> restaurants;

	

	public Specialite(int id, String nom, List<Restaurant> restaurant) {
		super();
		this.id = id;
		this.nom = nom;
		this.restaurants = restaurant;
	}

	public Specialite() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Restaurant> getRestaurant() {
		return restaurants;
	}

	public void setRestaurant(List<Restaurant> restaurant) {
		this.restaurants = restaurant;
	}
	
	
	

}
