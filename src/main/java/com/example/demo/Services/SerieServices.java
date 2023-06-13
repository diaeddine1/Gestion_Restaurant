package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.IDao.IDao;

import com.example.demo.entities.Serie;
import com.example.demo.repository.SerieRepository;

@Service
public class SerieServices implements IDao<Serie>{

	@Autowired
	private SerieRepository sr;
	
	@Override
	public void save(Serie o) {
		// TODO Auto-generated method stub
		sr.save(o);
	}

	@Override
	public void delete(Serie o) {
		// TODO Auto-generated method stub
		sr.delete(o);
	}

	@Override
	public void update(Serie o) {
		// TODO Auto-generated method stub
		sr.save(o);
	}

	@Override
	public List<Serie> findAll() {
		// TODO Auto-generated method stub
		return sr.findAll();
	}

	@Override
	public Serie findById(int id) {
		// TODO Auto-generated method stub
		return sr.findById(id);
	}

}
