package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.IDao.IDao;
import com.example.demo.entities.Ville;
import com.example.demo.repository.VilleRepository;
@Service
public class VilleServices implements IDao<Ville>{
	
	@Autowired
	private VilleRepository vr;
	
	@Override
	public void save(Ville o) {
		// TODO Auto-generated method stub
		vr.save(o);
		
	}

	@Override
	public void delete(Ville o) {
		// TODO Auto-generated method stub
		vr.delete(o);
	}

	@Override
	public void update(Ville o) {
		// TODO Auto-generated method stub
		vr.save(o);
	}

	@Override
	public List<Ville> findAll() {
		// TODO Auto-generated method stub
		
		return vr.findAll();
	}

	@Override
	public Ville findById(int id) {
		// TODO Auto-generated method stub
		return vr.findById(id);
	}

}
