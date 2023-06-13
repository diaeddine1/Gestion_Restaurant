package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.IDao.IDao;
import com.example.demo.entities.Restaurant;
import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServices implements IDao<User>{
	
	@Autowired
	private UserRepository ur;
	
	@Override
	public void save(User o) {
		// TODO Auto-generated method stub
		ur.save(o);
		
	}

	@Override
	public void delete(User o) {
		// TODO Auto-generated method stub
		ur.delete(o);
	}

	@Override
	public void update(User o) {
		// TODO Auto-generated method stub
		ur.save(o);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		
		return ur.findAll();
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return ur.findById(id);
	}
	
	public User findByEmailAndPassword(String email, String password) {
		return ur.findByEmailAndPassword(email, password);
		
	}
	
	


}
