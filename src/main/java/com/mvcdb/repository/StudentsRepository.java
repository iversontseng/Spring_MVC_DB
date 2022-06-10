package com.mvcdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mvcdb.model.Students;

public interface StudentsRepository extends JpaRepository<Students, Long>{
	public List<Students> findByName(String name);
}
