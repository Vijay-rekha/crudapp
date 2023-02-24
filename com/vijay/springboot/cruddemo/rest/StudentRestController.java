package com.vijay.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.springboot.cruddemo.entity.Student;
import com.vijay.springboot.cruddemo.service.StudentService;


@RestController
@RequestMapping("/api")
public class StudentRestController {

	@Autowired
	private StudentService studentService;
	
	
	public StudentRestController(StudentService theStudentService ) {
		studentService  = theStudentService ;
	}
	
		@GetMapping("/students")
	public List<Student> findAll() {
		return studentService.findAll();
		}

	
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		Student theStudent = studentService.findById(studentId);
		
		if (theStudent == null) {
			throw new RuntimeException("Employee id not found - " + studentId);
		}
		
		return theStudent;
	}
	
	// add mapping for POST /employees - add new employee
	
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student theStudent) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theStudent.setId(0);
		
		studentService.save(theStudent);
		
		return theStudent;
	}
	
	// add mapping for PUT /employees - update existing employee
	
	@PutMapping("/students")
	public Student updateEmployee(@RequestBody Student theStudent) {
		
		studentService.save(theStudent);
		
		return theStudent;
	}
	
	// add mapping for DELETE /employees/{employeeId} - delete employee
	
	@DeleteMapping("/students/{studentId}")
	public String deleteStudent(@PathVariable int studentId) {
		
		Student tempStudent = studentService.findById(studentId);
		
		// throw exception if null
		
		if (tempStudent == null) {
			throw new RuntimeException("Student id not found - " + studentId);
		}
		
		studentService.deleteById(studentId);
		
		return "Deleted Student id - " + studentId;
	}
	
}





