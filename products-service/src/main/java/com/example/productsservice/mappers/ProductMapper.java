package com.example.productsservice.mappers;

import com.example.productsservice.dtos.ProductRequest;
import com.example.productsservice.dtos.ProductResponse;
import com.example.productsservice.entities.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMapper extends Mapper<ProductRequest, ProductResponse, Product> {

    @Override
    public ProductRequest toRequest(Product entity) {
        return ProductRequest.builder()
                .name(entity.getName())
                .registrationAt(entity.getRegistrationAt())
                .price(entity.getPrice())
                .stock(entity.getStock())
                .build();
    }

    @Override
    public ProductResponse toResponse(Product entity) {
        return ProductResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .registrationAt(entity.getRegistrationAt())
                .price(entity.getPrice())
                .stock(entity.getStock())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    @Override
    public Product fromRequest(ProductRequest productRequest) {

        return Product.builder()
                .name(productRequest.getName())
                .registrationAt(productRequest.getRegistrationAt())
                .price(productRequest.getPrice())
                .stock(productRequest.getStock())
                .build();

    }

    @Override
    public Product fromResponse(ProductResponse productResponse) {

        return Product.builder()
                .id(productResponse.getId())
                .name(productResponse.getName())
                .registrationAt(productResponse.getRegistrationAt())
                .price(productResponse.getPrice())
                .stock(productResponse.getStock())
                .createdAt(productResponse.getCreatedAt())
                .updatedAt(productResponse.getUpdatedAt())
                .build();
    }

    @Override
    public List<ProductRequest> toRequest(List<Product> entities) {

        return entities.stream().map(this::toRequest).toList();
    }

    @Override
    public List<ProductResponse> toResponse(List<Product> entities) {

        return entities.stream().map(this::toResponse).toList();
    }

    @Override
    public List<Product> fromRequests(List<ProductRequest> productRequests) {

        return productRequests.stream().map(this::fromRequest).toList();
    }

    @Override
    public List<Product> fromResponse(List<ProductResponse> productResponses) {

        return productResponses.stream().map(this::fromResponse).toList();
    }
}
