package com.digits.mybeerservice.web.model;

import java.time.OffsetDateTime;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {

    @Null
    private UUID id;

    @NotBlank
    @Size(min = 3, max = 100)
    private String customerName;

    @Null(message = "version must be null")
    private Integer version;

    @Null(message = "createDate must be null")
    private OffsetDateTime createdDate;

    @Null(message = "lastModifiedDate must be null")
    private OffsetDateTime lastModifiedDate;
}
