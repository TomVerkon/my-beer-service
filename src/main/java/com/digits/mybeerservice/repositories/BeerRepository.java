package com.digits.mybeerservice.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.digits.mybeerservice.domain.Beer;

@Repository
public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {

    Optional<Beer> findByUpc(Long upc);

}
