package com.example.productsservice.controllers;

import com.example.productsservice.controllers.common.ResourceController;
import com.example.productsservice.dtos.ProductRequest;
import com.example.productsservice.dtos.ProductResponse;
import com.example.productsservice.mappers.ProductMapper;
import com.example.productsservice.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@RequestMapping("/api/products")
@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductController implements ResourceController<ProductRequest, ProductResponse, Long> {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @Override
    public CompletableFuture<List<ProductResponse>> findAll() {

        return CompletableFuture
                .supplyAsync(productService::findAll)
                .thenApplyAsync(productMapper::toResponse);
    }

    @Override
    public CompletableFuture<Optional<ProductResponse>> findById(Long id) {

        return CompletableFuture
                .supplyAsync(() -> id)
                .thenApplyAsync(productService::findById)
                .thenApplyAsync(optionalProduct -> optionalProduct.map(productMapper::toResponse));
    }

    @Override
    public CompletableFuture<ProductResponse> save(ProductRequest productRequest) {

        return CompletableFuture
                .supplyAsync(() -> productMapper.fromRequest(productRequest))
                .thenApplyAsync(productService::save)
                .thenApplyAsync(productMapper::toResponse);
    }

    @Override
    public CompletableFuture<ProductResponse> update(Long id, ProductRequest productRequest) {

        return CompletableFuture
                .supplyAsync(() -> productMapper.fromRequest(productRequest))
                .thenApplyAsync(product -> productService.update(id, product))
                .thenApplyAsync(productMapper::toResponse);
    }

    @Override
    public CompletableFuture<Boolean> deleteById(Long id) {

        return CompletableFuture
                .supplyAsync(() -> id)
                .thenApplyAsync(productService::deleteById);
    }
}
