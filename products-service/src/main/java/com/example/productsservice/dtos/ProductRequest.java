package com.example.productsservice.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@Builder
@ToString
public class ProductRequest {

    private String name;

    @JsonProperty("registration_at")
    private Date registrationAt;

    private double price;

    private Integer stock;
}
