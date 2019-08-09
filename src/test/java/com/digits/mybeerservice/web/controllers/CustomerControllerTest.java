package com.digits.mybeerservice.web.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.digits.mybeerservice.services.BeerService;
import com.digits.mybeerservice.services.CustomerService;
import com.digits.mybeerservice.web.model.CustomerDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

	@MockBean
	CustomerService customerService;

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetCustomerById() throws Exception {
		mockMvc.perform(get("/api/v1/customer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	void testRegisterNewCustomr() throws Exception {
		CustomerDto customrDto = CustomerDto.builder().build();
		String customerDtoJson = objectMapper.writeValueAsString(customrDto);

		mockMvc.perform(post("/api/v1/customer/").contentType(MediaType.APPLICATION_JSON).content(customerDtoJson))
				.andExpect(status().isCreated());
	}

}
