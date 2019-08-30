package com.digits.mybeerservice.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.digits.mybeerservice.domain.Customer;
import com.digits.mybeerservice.web.model.CustomerDto;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CustomerMapperTest {
    
    @Autowired
    CustomerMapperImpl customerMapper;
    
    String now;

    @BeforeEach
    void setUp() throws Exception {
	now = Instant.now().toString();
    }

    @Test
    void testCustomerToCustomerDto() {
	UUID id = UUID.randomUUID();
	String customerName = "Joe BagOfDonuts";
	Customer customer = customerMapper.customerDtoToCustomer(CustomerDto.builder().customerName(customerName).id(id).createdDate(OffsetDateTime.parse(now,  DateTimeFormatter.ISO_INSTANT)).build());
	assertNotNull(customer);
	assertEquals(id.toString(), customer.getId().toString());
	assertEquals(customerName, customer.getCustomerName());
	assertEquals(now, customer.getCreatedDate().toInstant().toString());
    }

    @Test
    void testCustomerDtoToCustomer() {
	UUID id = UUID.randomUUID();
	String customerName = "Joe BagOfDonuts";
	CustomerDto customer = customerMapper.customerToCustomerDto(Customer.builder().customerName(customerName).id(id).build());
	assertNotNull(customer);
	assertEquals(id.toString(), customer.getId().toString());
	assertEquals(customerName, customer.getCustomerName());
    }

}
