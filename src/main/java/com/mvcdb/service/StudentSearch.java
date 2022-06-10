package com.mvcdb.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvcdb.repository.StudentsRepository;


import com.mvcdb.model.Students;
@Service
public class StudentSearch {
	@Autowired
	private StudentsRepository repo;
	
	public List<Students> listAll(){
		return repo.findAll();
	}
	public void save(Students student) {
		repo.save(student);
	}
	public Students get(Long id) {
		return repo.findById(id).get();
	}
	public void delete(Long id) {
		repo.deleteById(id);
	}
	public List<Students> findByName(String name){
		return repo.findByName(name);
	}
}
