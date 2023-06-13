package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.IDao.IDao;
import com.example.demo.entities.Zone;

import com.example.demo.repository.ZoneRepository;
@Service
public class ZoneServices implements IDao<Zone>{
	@Autowired
	private ZoneRepository zr;

	@Override
	public void save(Zone o) {
		// TODO Auto-generated method stub
		zr.save(o);

	}

	@Override
	public void delete(Zone o) {
		// TODO Auto-generated method stub
		zr.delete(o);
	}

	@Override
	public void update(Zone o) {
		// TODO Auto-generated method stub
		zr.save(o);
	}

	@Override
	public List<Zone> findAll() {
		// TODO Auto-generated method stub

		return zr.findAll();
	}

	@Override
	public Zone findById(int id) {
		// TODO Auto-generated method stub
		return zr.findById(id);
	}

}
