package com.example.demo.entities;





import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String phone_number;
	private String email;
	private String nom;
	private String password;
	private String role;
	private String status;

	@JsonIgnore
	@ManyToMany
	private List<Restaurant> restaurants;

	@JsonIgnore
	@ManyToMany
	private List<Roles> roles;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
	private List<Reservation> reservations;
	
	
	public User() {
		super();
	}
	
	
	
	


	

	public User(int id, String phone_number, String email, String nom, String password, String role, String status,
			List<Restaurant> restaurants, List<Roles> roles, List<Reservation> reservations) {
		super();
		this.id = id;
		this.phone_number = phone_number;
		this.email = email;
		this.nom = nom;
		this.password = password;
		this.role = role;
		this.status = status;
		this.restaurants = restaurants;
		this.roles = roles;
		this.reservations = reservations;
	}








	public List<Reservation> getReservations() {
		return reservations;
	}



	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}


	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}


	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}
	
	
	

	

}
