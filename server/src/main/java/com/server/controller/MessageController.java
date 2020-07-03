package com.server.controller;

import java.util.ArrayList;
import java.util.List;

import com.server.model.Message;
import com.server.repository.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    // @GetMapping("/getMessages")
    // public List<Message> getMessages() {
    //     return messageRepository.findAll();
    // }
    @GetMapping("/getMessages")
    public ResponseEntity<List<Message>> getMessages() {
        List<Message> messages = new ArrayList<Message>();
        messageRepository.findAll().forEach(messages::add);

        if (messages.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(messages, HttpStatus.OK);
    }
}