package com.digits.mybeerservice.services;

import java.util.UUID;

import com.digits.mybeerservice.web.model.BeerDto;

public interface BeerService {

    BeerDto getBeerById(UUID beerId);

    BeerDto getBeerByUpc(Long upc);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    void deleteBeerById(UUID beerId);

}
