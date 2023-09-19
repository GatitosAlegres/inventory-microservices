package com.example.productsservice.entities;

import java.time.LocalDateTime;

public interface Identifiable<K> {
        K getId();
        
        void setId(K id);

        LocalDateTime getCreatedAt();

        void setCreatedAt(LocalDateTime createdAt);
}