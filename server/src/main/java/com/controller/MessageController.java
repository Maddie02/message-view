package com.controller;

import java.util.List;

import com.model.Message;
import com.repository.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getMessages")
    public List<Message> getMessages() {
        return messageRepository.findAll();
    }
}