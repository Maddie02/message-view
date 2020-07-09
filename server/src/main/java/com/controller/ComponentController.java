package com.controller;

import com.model.Component;
import com.model.Message;
import com.model.User;
import com.repository.ComponentRepository;
import com.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ComponentController {

    @Autowired
    private ComponentRepository componentRepository;

    @GetMapping("/getComponent_ALF")
    public Component getComponent_ALF() {
        return componentRepository.findByComponentName("FastLane");
    }

}
