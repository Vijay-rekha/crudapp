package com.vijay.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vijay.springboot.cruddemo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	// that's it ... no need to write any code LOL!
	
}
