package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.ReservationServices;
import com.example.demo.Services.RestaurantServices;
import com.example.demo.Services.UserServices;
import com.example.demo.entities.Reservation;
import com.example.demo.entities.Restaurant;
import com.example.demo.entities.User;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserServices userServices;
	@Autowired
	private RestaurantServices restaurantServices;

	@PostMapping("/save")	
	public void save(@RequestBody User user) {
		userServices.save(user);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		User s = userServices.findById(Integer.parseInt(id));
		userServices.delete(s);}

	@GetMapping("/all")
	public List<User> findAll() {
		return userServices.findAll();
	}
	
	@CrossOrigin
	@PostMapping("/login")
	public Map<String, Object> login(@RequestBody Map<String, String> loginData) {
		Map<String, Object> response = new HashMap<>();
		String email = loginData.get("email");
		String password = loginData.get("password");
        User user = userServices.findByEmailAndPassword(email, password);
        if (user != null) {
        	response.put("id",user.getId());
        	response.put("role",user.getRole());
        	response.put("nom", user.getNom());
            return response;
        } else {
        	response.put("error","not found");
            return response;
        }
    }
	
	@GetMapping("/{id}/favorites")
	public List<Restaurant> getUserFavorites(@PathVariable int id) {
		User user = userServices.findById(id);
		if (user != null) {
			return user.getRestaurants();
		} else {
			throw new org.webjars.NotFoundException("User not found");
		}
	}
	
	 @PostMapping("/{id}/favorites/{restaurantId}")
	    public void addFavoriteRestaurant(@PathVariable int id, @PathVariable int restaurantId) {
	        User user = userServices.findById(id);
	        Restaurant restaurant = restaurantServices.findById(restaurantId);
	        
	        if (user != null && restaurant != null) {
	            List<Restaurant> favorites = user.getRestaurants();
	            favorites.add(restaurant);
	            user.setRestaurants(favorites);
	            userServices.save(user);
	        } else {
	            throw new org.webjars.NotFoundException("User or Restaurant not found");
	        }
	    }
	 
	 @DeleteMapping("/{id}/favorites/{restaurantId}")
	 public ResponseEntity<String> removeFavoriteRestaurant(@PathVariable int id, @PathVariable int restaurantId) {
	     User user = userServices.findById(id);
	     if (user != null) {
	         List<Restaurant> favoriteRestaurants = user.getRestaurants();
	         Restaurant restaurantToRemove = null;
	         for (Restaurant restaurant : favoriteRestaurants) {
	             if (restaurant.getId() == restaurantId) {
	                 restaurantToRemove = restaurant;
	                 break;
	             }
	         }
	         if (restaurantToRemove != null) {
	             favoriteRestaurants.remove(restaurantToRemove);
	             userServices.save(user);
	             return ResponseEntity.ok("Favorite restaurant removed successfully");
	         } else {
	             return ResponseEntity.notFound().build();
	         }
	     } else {
	         return ResponseEntity.notFound().build();
	     }
	 }

	
	
}
