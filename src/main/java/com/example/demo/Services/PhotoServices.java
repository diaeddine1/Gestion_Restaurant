package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.IDao.IDao;
import com.example.demo.entities.Photo;
import com.example.demo.entities.Ville;
import com.example.demo.repository.PhotoRepository;


@Service
public class PhotoServices implements IDao<Photo>{
	
	@Autowired
	private PhotoRepository photor;

	@Override
	public void save(Photo r) {
		
		photor.save(r);
		
	}

	@Override
	public void delete(Photo r) {
		photor.delete(r);
		
	}

	@Override
	public void update(Photo r) {
		photor.save(r);
		
	}

	@Override
	public List<Photo> findAll() {
		// TODO Auto-generated method stub
		
		return photor.findAll();
	}

	@Override
	public Photo findById(int id) {
		
		return photor.findById(id);
	}
	
	

}
