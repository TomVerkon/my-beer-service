package com.digits.mybeerservice.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.digits.mybeerservice.web.model.BeerDto;
import com.digits.mybeerservice.web.model.BeerStyleEnum;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

	@Override
	public BeerDto getBeerById(UUID beerId) {
		return BeerDto.builder().id(UUID.randomUUID()).beerName("Coors Lite").beerStyle(BeerStyleEnum.LAGER).build();
	}

	@Override
	public BeerDto getBeerByUpc(Long upc) {
		return BeerDto.builder().id(UUID.randomUUID()).beerName("Corona").beerStyle(BeerStyleEnum.LAGER).upc(upc).build();
	}

	@Override
	public BeerDto saveNewBeer(BeerDto beerDto) {
		log.debug(beerDto.toString());
		beerDto.setId(UUID.randomUUID());
		return beerDto;
	}

	@Override
	public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBeerById(UUID beerId) {
		log.debug("Deleting beer with ID: " + beerId);
	}

}
