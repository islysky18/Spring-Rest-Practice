package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
	//add exception handler
	
	//Add an exception handler using @ExceptionHandler
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exe) {
			// create a studentErrorResponse
			StudentErrorResponse errorResponse = new StudentErrorResponse();
			
			errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
			errorResponse.setMessage(exe.getMessage());
			errorResponse.setTimeStamp(System.currentTimeMillis());
			
			// return ResponseEntity
			
			return new ResponseEntity<StudentErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
		}
		
		// add another exception handler to catch any exception
		
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
			
			//create a StudentErrorResponse
			StudentErrorResponse errorResponse = new StudentErrorResponse();
			
			errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
			errorResponse.setMessage(exc.getMessage());
			errorResponse.setTimeStamp(System.currentTimeMillis());
			
			
			
			return new ResponseEntity<StudentErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
		}
}
