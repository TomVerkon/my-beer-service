package com.digits.mybeerservice.repositories;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.digits.mybeerservice.domain.Customer;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, UUID>{

}
