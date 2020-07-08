package com.repository;

import java.util.Optional;

import com.model.Product;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
    public Optional<Product> findByProductCode(String productCode);
}