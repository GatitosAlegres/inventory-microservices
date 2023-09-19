package com.example.productsservice.mappers;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public abstract class Mapper<Request, Response, E> {

    public abstract Request toRequest(E entity);

    public abstract Response toResponse(E entity);

    public abstract E fromRequest(Request request);

    public abstract E fromResponse(Response response);

    public abstract List<Request> toRequest(List<E> entities);

    public abstract List<Response> toResponse(List<E> entities);

    public abstract List<E> fromRequests(List<Request> requests);

    public abstract List<E> fromResponse(List<Response> responses);
}
