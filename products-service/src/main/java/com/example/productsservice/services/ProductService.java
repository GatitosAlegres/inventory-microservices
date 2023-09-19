package com.example.productsservice.services;

import com.example.productsservice.entities.Product;
import com.example.productsservice.repositories.ProductJpaRepository;
import com.example.productsservice.services.common.ResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService extends ResourceService<Product, Long> {

    private final ProductJpaRepository productJpaRepository;

    @Override
    public JpaRepository<Product, Long> getJpaRepository() {
        return this.productJpaRepository;
    }
}
