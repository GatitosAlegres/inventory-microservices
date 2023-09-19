package com.example.productsservice.controllers.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface ResourceController<Request, Response, K> {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    CompletableFuture<List<Response>> findAll();

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    CompletableFuture<Optional<Response>> findById(@PathVariable K id);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CompletableFuture<Response> save(@RequestBody Request request);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    CompletableFuture<Response> update(@PathVariable K id, @RequestBody Request request);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    CompletableFuture<Boolean> deleteById(@PathVariable K id);
}
