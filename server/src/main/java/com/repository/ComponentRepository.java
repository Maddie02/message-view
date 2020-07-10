package com.repository;

import com.model.Component;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ComponentRepository extends MongoRepository<Component, String> {

    Component findByComponentName(String fastLane);
}
