package com.digits.mybeerservice.bootstrap;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.digits.mybeerservice.domain.Beer;
import com.digits.mybeerservice.domain.Customer;
import com.digits.mybeerservice.repositories.BeerRepository;
import com.digits.mybeerservice.repositories.CustomerRepository;
import com.digits.mybeerservice.web.model.BeerStyleEnum;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;
    private final CustomerRepository customerRepository;

    public BeerLoader(BeerRepository beerRepository, CustomerRepository customerRepository) {
	super();
	this.beerRepository = beerRepository;
	this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
	loadBeer();
    }

    private void loadBeer() {
	if (beerRepository.count() == 0) {
	    beerRepository.save(Beer.builder().beerName("Coors light").beerStyle(BeerStyleEnum.PALE_ALE)
		    .price(new BigDecimal("9.99")).quantityOnHand(300).upc(Long.MAX_VALUE - 1).build());
	    beerRepository.save(Beer.builder().beerName("Yeungling").beerStyle(BeerStyleEnum.LAGER)
		    .price(new BigDecimal("10.99")).quantityOnHand(500).upc(Long.MAX_VALUE - 2).build());
	    // System.out.println("Loaded " + beerRepository.count() + " beers");
	}
	if (customerRepository.count() == 0) {
	    customerRepository.save(Customer.builder().customerName("Tom Verkon").build());
	    customerRepository.save(Customer.builder().customerName("PaulS Verkon").build());
	}
    }

}
