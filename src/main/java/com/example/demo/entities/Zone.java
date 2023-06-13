package com.example.demo.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Zone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	@JsonIgnore
	@OneToMany(mappedBy = "zone",fetch = FetchType.EAGER)
	private List<Restaurant> restaurant;

	@ManyToOne
	private Ville ville;
	
	
	public Zone() {
		super();
	}
	

	public Zone(int id, String nom, List<Restaurant> restaurant, Ville ville) {
		super();
		this.id = id;
		this.nom = nom;
		this.restaurant = restaurant;
		this.ville = ville;
	}

	public Ville getVille() {
		return ville;
	}


	public void setVille(Ville ville) {
		this.ville = ville;
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
		return restaurant;
	}


	public void setRestaurant(List<Restaurant> restaurant) {
		this.restaurant = restaurant;
	}
	
}
