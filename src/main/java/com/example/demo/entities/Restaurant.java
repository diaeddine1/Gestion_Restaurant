package com.example.demo.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nom;
	private String phone;
	private String adresse;
	private String longitude;
	private String latitude;
	private String price_range;
	private String cuisine;
	private float review;
	private float rating;
	
	private String heure_open;
	
	private String heure_close;
	
	
	@ManyToOne
	private Zone zone;
	
	@OneToMany(mappedBy = "restaurant",fetch = FetchType.EAGER ,cascade = CascadeType.REMOVE)
	private List<Photo> photos;
	@JsonIgnore
	@ManyToMany(mappedBy = "restaurants",cascade = CascadeType.REMOVE)
	private List<Specialite> specialites;

	
	
	@ManyToOne
	private Serie serie;
	
	
	@JsonIgnore
	@ManyToMany(mappedBy = "restaurants",cascade = CascadeType.REMOVE)
	private List<User> users;

	
	
	@JsonIgnore
	@OneToMany(mappedBy = "restaurant",fetch = FetchType.EAGER)
	private List<Reservation> reservations;

		

	



	



	public Restaurant(int id, String nom, String phone, String adresse, String longitude, String latitude,
			String price_range, String cuisine, float review, float rating, String heure_open, String heure_close,
			Zone zone, List<Photo> photos, List<Specialite> specialites, Serie serie, List<User> users,
			List<Reservation> reservations) {
		super();
		this.id = id;
		this.nom = nom;
		this.phone = phone;
		this.adresse = adresse;
		this.longitude = longitude;
		this.latitude = latitude;
		this.price_range = price_range;
		this.cuisine = cuisine;
		this.review = review;
		this.rating = rating;
		this.heure_open = heure_open;
		this.heure_close = heure_close;
		this.zone = zone;
		this.photos = photos;
		this.specialites = specialites;
		this.serie = serie;
		this.users = users;
		this.reservations = reservations;
	}



	public List<Specialite> getSpecialites() {
		return specialites;
	}



	public void setSpecialites(List<Specialite> specialites) {
		this.specialites = specialites;
	}



	public List<Reservation> getReservations() {
		return reservations;
	}



	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}



	
	
	public List<User> getUsers() {
		return users;
	}



	public void setUsers(List<User> users) {
		this.users = users;
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

	

	public String getPrice_range() {
		return price_range;
	}



	public void setPrice_range(String price_range) {
		this.price_range = price_range;
	}



	public String getCuisine() {
		return cuisine;
	}



	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}



	public float getReview() {
		return review;
	}



	public void setReview(float review) {
		this.review = review;
	}



	public float getRating() {
		return rating;
	}



	public void setRating(float rating) {
		this.rating = rating;
	}



	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	

	public String getLongitude() {
		return longitude;
	}



	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}



	public String getLatitude() {
		return latitude;
	}



	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}


	
	
	
	public String getHeure_open() {
		return heure_open;
	}



	public void setHeure_open(String heure_open) {
		this.heure_open = heure_open;
	}



	public String getHeure_close() {
		return heure_close;
	}



	public void setHeure_close(String heure_close) {
		this.heure_close = heure_close;
	}



	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
	
	
	

	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public Restaurant() {
		super();
	}

	
	

}
