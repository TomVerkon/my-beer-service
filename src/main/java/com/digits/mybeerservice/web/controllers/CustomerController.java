package com.digits.mybeerservice.web.controllers;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digits.mybeerservice.services.CustomerService;
import com.digits.mybeerservice.web.model.CustomerDto;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
	super();
	this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId) {
	return new ResponseEntity<CustomerDto>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> registerNewCustomer(@RequestBody CustomerDto customerDto) {
	// todo implement
//		BeerDto savedBeer = beerService.saveNewBeer(beerDto);
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Location", "/api/v1/beer/" + savedBeer.getId().toString());
//		return new ResponseEntity<Object>(headers, HttpStatus.CREATED);
	CustomerDto savedDto = customerService.saveCustomer(customerDto);
	HttpHeaders headers = new HttpHeaders();
	headers.add("Location", "/api/v1/customer/" + savedDto.getId().toString());

	return new ResponseEntity<Object>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Object> updateCustomer(@PathVariable("customerId") UUID customerId,
	    @RequestBody CustomerDto customerDto) {
	customerService.updateCustomer(customerId, customerDto);
	return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable("customerId") UUID customerId) {
	customerService.deleteCustomer(customerId);
	return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }

}
