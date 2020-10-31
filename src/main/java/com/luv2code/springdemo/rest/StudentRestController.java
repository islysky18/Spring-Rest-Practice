package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	//define @PostCinstruct to load the student data.. only once!
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<>();
		theStudents.add(new Student("Chao-Ting", "Wen"));
		theStudents.add(new Student("Siqi", "Geng"));
		theStudents.add(new Student("John", "Wick"));	
	}
	
	// define endpoint for "/students" -> return list of student
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		
		return theStudents;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		//just index into the list
		
		//check the studentId against list size
		if((studentId >= theStudents.size()) || (studentId < 0)) {
			throw new StudentNotFoundException("Student id is not found - " + studentId);
		}
		
		return theStudents.get(studentId);
	}
	
	
	
	
	
}
