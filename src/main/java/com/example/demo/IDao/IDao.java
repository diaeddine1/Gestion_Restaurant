package com.example.demo.IDao;

import java.util.List;

public interface IDao<T>{
	
	void save(T o);
	
	void delete(T o);
	
	void update(T o);
	
	List<T> findAll();
	
	T findById(int id);

}
