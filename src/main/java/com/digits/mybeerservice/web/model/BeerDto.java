package com.digits.mybeerservice.web.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

    @Null(message = "id must be null")
    private UUID id;
    
    @NotBlank(message = "The beerName can not be blanl")
    private String beerName;
    
    @NotNull(message = "You must assign a beer style")
    private BeerStyleEnum beerStyle;
    
    @NotNull
    @Positive(message = "upc must be greater than 0")
    private Long upc;
    
    private Integer quantityOnHand;

    @NotNull
    @Positive(message = "price must be greater than 0")
    private BigDecimal price;

    @Null(message = "version must be null")
    private Integer version;

    @Null(message = "createDate must be null")
    private OffsetDateTime createdDate;

    @Null(message = "lastModifiedDate must be null")
    private OffsetDateTime lastModifiedDate;

}
