package com.controller;

import com.model.Component;
import com.repository.ComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
