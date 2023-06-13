package com.example.demo.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Services.PhotoServices;
import com.example.demo.Services.RestaurantServices;
import com.example.demo.entities.Photo;
import com.example.demo.entities.Restaurant;
import com.example.demo.repository.PhotoRepository;
import com.example.demo.repository.RestaurantRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("restaurants")
public class RestaurantController {
	@Autowired
	private RestaurantServices restaurantServices;



	@PostMapping("/save")	
	public void save(@RequestBody Restaurant restaurant) {
		restaurantServices.save(restaurant);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Restaurant s = restaurantServices.findById(Integer.parseInt(id));
		restaurantServices.delete(s);}

	@GetMapping("/all")
	public List<Restaurant> findAll() {
		return restaurantServices.findAll();
	}
	
	@GetMapping("/{restaurantId}/photos")
    public List<Photo> getRestaurantPhotos(@PathVariable int restaurantId) {
        Restaurant restaurant = restaurantServices.findById(restaurantId);
        if (restaurant != null) {
            return restaurant.getPhotos();
        } else {
            throw new RuntimeException("Restaurant not found");
        }
    }
	
	
	@PostMapping("/{restaurantId}/photos")
	public ResponseEntity<?> addPhotosToRestaurant(@PathVariable int restaurantId, @RequestBody List<String> photoUrls) {
	    try {
	        Restaurant restaurant = restaurantServices.findById(restaurantId);
	        if (restaurant == null) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Restaurant not found.");
	        }

	        List<Photo> photos = new ArrayList<>();
	        for (String photoUrl : photoUrls) {
	            Photo photo = new Photo();
	            photo.setUrl(photoUrl);
	            photo.setRestaurant(restaurant);
	            photos.add(photo);
	        }

	        restaurant.setPhotos(photos);
	        restaurantServices.save(restaurant);

	        return ResponseEntity.ok("Photos added to the restaurant successfully.");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add photos to the restaurant.");
	    }
	}

	 
	
	

}
