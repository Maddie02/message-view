package com.repository;

import com.model.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectRepo extends MongoRepository<Project, String> {
    public Project findByProjectName(String projectName);
}
