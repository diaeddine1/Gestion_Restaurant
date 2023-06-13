package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.PhotoServices;

import com.example.demo.entities.Photo;
import com.example.demo.entities.Ville;
import com.example.demo.repository.PhotoRepository;
import com.example.demo.repository.RestaurantRepository;


@RestController
@RequestMapping("photos")
public class PhotoController {
	
	@Autowired
	private PhotoServices photoServices;
	
	@Autowired
	private PhotoRepository photoRepository;
	
	@Autowired
	private RestaurantRepository restaurantRepository;

	

	@PostMapping("/save")	
	public void save(@RequestBody Photo photo) {
		photoServices.save(photo);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Photo s = photoServices.findById(Integer.parseInt(id));
		photoServices.delete(s);}

	@GetMapping("/all")
	public List<Photo> getAllPhotos() {
		return photoRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Photo> getPhotoById(@PathVariable(value = "id") int photoId) {
		Photo photo = photoRepository.findById(photoId);
		if (photo == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(photo);
	}

	@PostMapping("/save/{url}/{Rid}")
	public Photo createPhoto(@PathVariable String url,@PathVariable int Rid) {
		Photo photo = new Photo(url,restaurantRepository.findById(Rid)) ;
		return photoRepository.save(photo);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Photo> updatePhoto(@PathVariable(value = "id") int photoId, @RequestBody Photo photoDetails) {
		Photo photo = photoRepository.findById(photoId);
		if (photo == null) {
			return ResponseEntity.notFound().build();
		}
		photo.setUrl(photoDetails.getUrl());
		photo.setRestaurant(photoDetails.getRestaurant());

		Photo updatedPhoto = photoRepository.save(photo);
		return ResponseEntity.ok(updatedPhoto);
	}


}
