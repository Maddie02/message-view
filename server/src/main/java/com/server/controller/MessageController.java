package com.server.controller;

import java.util.List;

import com.server.model.Message;
import com.server.repository.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {


    @Autowired
    private MessageRepository messageRepository;

    @GetMapping(value = "/getMessages", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Message>> getMessages() {
        return ResponseEntity.ok(messageRepository.findAll());
    }

}