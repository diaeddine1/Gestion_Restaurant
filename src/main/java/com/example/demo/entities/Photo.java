package com.example.demo.entities;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Photo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String url;
	
	@ManyToOne
	@JsonIgnore
	private Restaurant restaurant;

	public Photo(int id, String url, Restaurant restaurant) {
		super();
		this.id = id;
		this.url = url;
		this.restaurant = restaurant;
	}
	
	public Photo(String url, Restaurant restaurant) {
		super();
		this.url = url;
		this.restaurant = restaurant;
	}

	public Photo() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}
