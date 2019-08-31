package com.digits.mybeerservice.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
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
    CustomerMapper customerMapper;

    @Autowired
    DateTimeMapper dateTimeMapper;

    @BeforeEach
    void setUp() throws Exception {
    }

    @Test
    void testCustomerDtoToCustomer() {
	UUID id = UUID.randomUUID();
	String customerName = "Joe BagOfDonuts";
	OffsetDateTime now = OffsetDateTime.now(ZoneId.of("Z"));
	Customer customer = customerMapper.customerDtoToCustomer(
		CustomerDto.builder().customerName(customerName).id(id).createdDate(now).build());
	assertNotNull(customer);
	assertEquals(id.toString(), customer.getId().toString());
	assertEquals(customerName, customer.getCustomerName());
	assertEquals(now, dateTimeMapper.timestampToOffsetDateTime(customer.getCreatedDate()));
    }

    @Test
    void testCustomerToCustomerDto() {
	UUID id = UUID.randomUUID();
	String customerName = "Joe BagOfDonuts";
	Timestamp now = Timestamp.from(Instant.now());
	CustomerDto customer = customerMapper
		.customerToCustomerDto(Customer.builder().customerName(customerName).id(id).createdDate(now).build());
	assertNotNull(customer);
	assertEquals(id.toString(), customer.getId().toString());
	assertEquals(customerName, customer.getCustomerName());
	assertEquals(now, dateTimeMapper.offsetDateTimeToTimestamp(customer.getCreatedDate()));
    }

}
