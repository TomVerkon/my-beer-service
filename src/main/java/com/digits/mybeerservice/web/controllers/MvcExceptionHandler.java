package com.digits.mybeerservice.web.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MvcExceptionHandler {

//    @ExceptionHandler(ConstraintViolationException.class)
//    ResponseEntity<List<String>> validationErrorHandler(ConstraintViolationException e) {
//	List<String> errors = new ArrayList<String>();
//	e.getConstraintViolations().forEach(cv -> {
//	    errors.add(cv.getPropertyPath() + " : " + cv.getMessage());
//	});
//	
//	System.out.println(errors);
//	return new ResponseEntity<List<String>>(errors, HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<List<ObjectError>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
	return new ResponseEntity<List<ObjectError>>(e.getBindingResult().getAllErrors(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BindException.class)
    ResponseEntity<List<ObjectError>> bindExceptionHandler(BindException e) {
	return new ResponseEntity<List<ObjectError>>(e.getAllErrors(), HttpStatus.BAD_REQUEST);
    }
}
