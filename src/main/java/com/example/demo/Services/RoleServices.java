package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.IDao.IDao;
import com.example.demo.entities.Roles;
import com.example.demo.repository.RoleRepository;



public class RoleServices implements IDao<Roles>{
	
	@Autowired
	private RoleRepository rr;

	@Override
	public void save(Roles o) {
		// TODO Auto-generated method stub
		rr.save(o);
	}

	@Override
	public void delete(Roles o) {
		// TODO Auto-generated method stub
		rr.delete(o);
	}

	@Override
	public void update(Roles o) {
		// TODO Auto-generated method stub
		rr.save(o);
	}

	@Override
	public List<Roles> findAll() {
		// TODO Auto-generated method stub
		return rr.findAll();
	}

	@Override
	public Roles findById(int id) {
		// TODO Auto-generated method stub
		return rr.findById(id);
	}

}
