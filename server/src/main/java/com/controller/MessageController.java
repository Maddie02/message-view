package com.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.model.Message;
import com.repository.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/getMessages")
    public List<Message> getMessages(HttpServletRequest request, HttpServletResponse response)
    {
        String userName = null;
        Cookie[] cookies = request.getCookies();
        System.out.println();
        if(cookies !=null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("username")) userName = cookie.getValue();
            }
        }
        if(userName == null) {
            response.setHeader("Location","http://localhost:3000/log-in");
            response.setStatus(302);
            return null;
        }else {
            return messageRepository.findAll();
        }
    }

    @GetMapping("/messages/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) {

        String userName = null;
        Cookie[] cookies = request.getCookies();
        if(cookies !=null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("username")){
                    userName = cookie.getValue();
                }
            }
        }
        if(userName == null) {
            response.setHeader("Location","http://localhost:3000/log-in");
            response.setStatus(302);
            return null;
        }else {
            Optional<Message> messageData = messageRepository.findById(id);
            if (messageData.isPresent()) {
                return new ResponseEntity<>(messageData.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
    }
}