package com.controller;

import java.util.Optional;

import com.model.Product;
import com.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ProductController {
    
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable("name") String name) {
        Optional<Product> productData =  productRepository.findByProductCode(name);

        if (productData.isPresent()) {
            return new ResponseEntity<>(productData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}