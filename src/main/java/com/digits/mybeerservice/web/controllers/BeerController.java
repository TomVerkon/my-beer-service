package com.digits.mybeerservice.web.controllers;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digits.mybeerservice.web.model.BeerDto;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
	
	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId) {
		// todo implement
		return new ResponseEntity<BeerDto>(BeerDto.builder().id(UUID.randomUUID()).build(), HttpStatus.OK);
	}
	
	@GetMapping("/upc/{upc}")
	public ResponseEntity<BeerDto> getBeerByUpc(@PathVariable("upc") Long upc) {
		// todo implement
		return new ResponseEntity<BeerDto>(BeerDto.builder().upc(upc).build(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> saveNewBeer(@RequestBody BeerDto beerDto) {
		// todo implement
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	@PutMapping("/{beerId}")
	public ResponseEntity<?> updateBeerById(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto) {
		// todo implement
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

}
