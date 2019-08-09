package com.digits.mybeerservice.web.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
import com.digits.mybeerservice.web.model.BeerDto;
import com.digits.mybeerservice.web.model.BeerStyleEnum;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @MockBean
    BeerService beerService;

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetBeerById() throws Exception {
		mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	void testGetBeerByUpc() throws Exception {
		mockMvc.perform(get("/api/v1/beer/upc/" + String.valueOf(Long.MAX_VALUE)).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	void testSaveNewBeer() throws Exception {
        //given
        BeerDto beerDto = BeerDto.builder().beerName("Trash").beerStyle(BeerStyleEnum.PALE_ALE).upc(Long.MAX_VALUE).build();
        BeerDto savedDto = BeerDto.builder().beerName("Trash").beerStyle(BeerStyleEnum.PALE_ALE).upc(Long.MAX_VALUE).id(UUID.randomUUID()).build();
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        given(beerService.saveNewBeer(any())).willReturn(savedDto);

        mockMvc.perform(post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isCreated());


	}

	@Test
	void testUpdateBeerById() throws Exception {

		BeerDto beerDto = BeerDto.builder().build();
		String beerDtoJson = objectMapper.writeValueAsString(beerDto);

		mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID().toString()).contentType(MediaType.APPLICATION_JSON)
				.content(beerDtoJson)).andExpect(status().isNoContent());
	}

}
