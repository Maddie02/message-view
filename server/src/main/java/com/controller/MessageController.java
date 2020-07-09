package com.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.model.EntityState;
import com.model.Message;
import com.model.User;
import com.repository.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/getMessages")
    public List<Message> getMessages() {
        return messageRepository.findAll();
    }

    @GetMapping("/messages/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable("id") String id) {
        Optional<Message> messageData = messageRepository.findById(id);

        if (messageData.isPresent()) {
            return new ResponseEntity<>(messageData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/createMessage", method = RequestMethod.POST)
    public boolean createMessage(
            @RequestParam(value = "messageID") String messageID,
            @RequestParam(value = "text") String text,
            @RequestParam(value = "translation") boolean isForTranslation,
            @RequestParam(value = "documentation") boolean isForDocumentation,
            HttpServletResponse response)
    {
        if(messageRepository.findByMessageID(messageID) != null)return false;
        EntityState state = EntityState.NEW;
        //User user = <User from Session> for creator and last modifier
        LocalDateTime date = LocalDateTime.now(); //for created Date and last modified Date

        String consistentMessageId = "";
        /* TO DO: from where to take this parameters
        String consistentComponentId = ? - component
        String consistentProjectId = ? - project
        String version = ? -
        String messageType = ? - component
        */

        Map<String, EntityState> views = new HashMap<String, EntityState>();


        //messageRepository.insert(new Message(consistentMessageId, consistentComponentId, consistentProjectId, messageID, text, version, messageType, state, isForDocumentation, isForTranslation, views, user.getUsername(), date, user.getUsername(), date)); //insert into collection
        Message message = messageRepository.findByMessageID(messageID);
        message.setConsistentMessageID(message.getId());
        messageRepository.save(message);


        response.setHeader("Location","http://localhost:3000");
        response.setStatus(302);
        return true;
    }
}