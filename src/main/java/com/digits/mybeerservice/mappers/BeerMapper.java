package com.digits.mybeerservice.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.digits.mybeerservice.domain.Beer;
import com.digits.mybeerservice.web.model.BeerDto;

@Mapper(componentModel = "spring", uses = DateTimeMapper.class)
public interface BeerMapper {

    BeerMapper INSTANCE = Mappers.getMapper(BeerMapper.class);

    public Beer beerDtoToBeer(BeerDto beerDto);

    public BeerDto beerToBeerDto(Beer beer);

}
