package com.digits.mybeerservice.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.digits.mybeerservice.domain.Beer;
import com.digits.mybeerservice.mappers.BeerMapper;
import com.digits.mybeerservice.repositories.BeerRepository;
import com.digits.mybeerservice.web.model.BeerDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper mapper;

    @Override
    public BeerDto getBeerById(UUID beerId) {
	return mapper.beerToBeerDto(beerRepository.findById(beerId).orElseThrow(NotFoundException::new));
    }

    @Override
    public BeerDto getBeerByUpc(String upc) {
	return mapper.beerToBeerDto(beerRepository.findByUpc(upc).orElseThrow(NotFoundException::new));
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
	log.debug(beerDto.toString());
	return mapper.beerToBeerDto(beerRepository.save(mapper.beerDtoToBeer(beerDto)));
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
	log.debug(beerDto.toString());
	Beer existingBeer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);
	existingBeer.setBeerName(beerDto.getBeerName());
	existingBeer.setBeerStyle(beerDto.getBeerStyle());
	existingBeer.setPrice(beerDto.getPrice());
	existingBeer.setUpc(beerDto.getUpc());
	return mapper.beerToBeerDto(beerRepository.save(existingBeer));
    }

    @Override
    public void deleteBeerById(UUID beerId) {
	log.debug("Deleting beer with ID: " + beerId);
	beerRepository.deleteById(beerId);
    }

}
