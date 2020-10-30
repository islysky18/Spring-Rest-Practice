package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	// define enpoint for "/students" -> return list of student
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		
		List<Student> theStudents = new ArrayList<Student>();
		theStudents.add(new Student("Chao-Ting", "Wen"));
		theStudents.add(new Student("Siqi", "Geng"));
		theStudents.add(new Student("John", "Wick"));
		return theStudents;
	}
	
}
