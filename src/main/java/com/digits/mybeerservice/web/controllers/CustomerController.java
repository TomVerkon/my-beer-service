package com.digits.mybeerservice.web.controllers;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digits.mybeerservice.web.model.CustomerDto;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {
	
	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerDto> getCustomerById(@PathVariable UUID customerId) {
		// todo implement
		return new ResponseEntity<CustomerDto>(CustomerDto.builder().id(customerId).build(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> registerNewCustomr(@RequestBody CustomerDto customerDto) {
		// todo implement
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	

}
