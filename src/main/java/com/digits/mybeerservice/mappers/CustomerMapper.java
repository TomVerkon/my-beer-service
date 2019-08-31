package com.digits.mybeerservice.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.digits.mybeerservice.domain.Customer;
import com.digits.mybeerservice.web.model.CustomerDto;

@Mapper(componentModel = "spring", uses = DateTimeMapper.class)
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    public CustomerDto customerToCustomerDto(Customer customer);

    public Customer customerDtoToCustomer(CustomerDto customerDto);

}
