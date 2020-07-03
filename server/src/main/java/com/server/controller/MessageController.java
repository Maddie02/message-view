package com.server.controller;

import java.util.List;

import com.server.model.Message;
import com.server.repository.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {


    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/getMessages")
    public List<Message> getMessages() {
        return messageRepository.findAll();
    }
}