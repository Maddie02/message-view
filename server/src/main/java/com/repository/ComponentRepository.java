package com.repository;

import com.model.Component;
import com.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface ComponentRepository extends MongoRepository<Component, String> {

    Component findByComponentName(String fastLane);
}
