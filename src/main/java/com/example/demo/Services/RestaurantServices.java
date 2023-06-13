package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.IDao.IDao;
import com.example.demo.entities.Restaurant;
import com.example.demo.repository.RestaurantRepository;

@Service
public class RestaurantServices implements IDao<Restaurant>{
	
	@Autowired
	private RestaurantRepository restor;

	@Override
	public void save(Restaurant o) {
		
		restor.save(o);
		
	}

	@Override
	public void delete(Restaurant o) {
		// TODO Auto-generated method stub
		restor.delete(o);
	}

	@Override
	public void update(Restaurant o) {
		// TODO Auto-generated method stub
		restor.save(o);
	}

	@Override
	public List<Restaurant> findAll() {
		// TODO Auto-generated method stub
		return restor.findAll();
	}

	@Override
	public Restaurant findById(int id) {
		// TODO Auto-generated method stub
		return restor.findById(id);
	}

}
