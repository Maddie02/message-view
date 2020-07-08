package com.controller;

import com.model.Project;
import com.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProjectController {
    @Autowired
    private ProjectRepo repository;

    @GetMapping(value = "/getProjects", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Project>> getProjects(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping(value = "/getProjects/{name}")
    public Project getCurrentProject(@PathVariable(value = "name") String name){
        return repository.findByProjectName(name);
    }

}
