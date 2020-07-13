package com.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

import com.model.*;
import com.repository.ComponentRepository;
import com.repository.MessageRepository;

import com.repository.ProjectRepo;
import com.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ComponentRepository componentRepository;

    @Autowired
    private ProjectRepo projectRepository;

    @Autowired
    private UserRepo userRepository;

    public Project getCurrentProject(String name){
        return projectRepository.findByProjectName(name);
    }
    public Component getComponent_ALFABET() {
        return componentRepository.findByComponentName("FastLane");
    }

    public User getCurrentUser(String name){
        return userRepository.findByUsername(name);
    }

    @GetMapping("/getMessages")
    public List<Message> getMessages(HttpServletResponse response) throws IOException {
        if(messageRepository.count() > 20)response.sendRedirect("http://localhost:8080/getMessages/1");
        return messageRepository.findAll();
    }

    @GetMapping("/getMessages/{number}")
    public List<Message> getLimitedMessages(@PathVariable(name = "number") Integer number, HttpServletResponse response) throws IOException {
        if(messageRepository.count() <= 20)response.sendRedirect("http://localhost:8080/getMessages");
        number--;
        if(number < 0)number = 0;
        if(messageRepository.count()/20 < number){
            number = Math.toIntExact(messageRepository.count() / 20);
        }
        Pageable pageableRequest = PageRequest.of(number, 20);
        return messageRepository.findAll(pageableRequest).getContent();
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
            @RequestParam(value = "translation", defaultValue="false") Boolean isForTranslation,
            @RequestParam(value = "documentation", defaultValue="false") Boolean isForDocumentation,
            @RequestParam(value = "messageType") String messageType,

            HttpServletResponse response)
    {
        if(messageRepository.findByMessageID(messageID) != null)return false;
        EntityState state = EntityState.NEW;
        //User user = <User from Session> for creator and last modifier
        User user = getCurrentUser("looo");
        LocalDateTime date = LocalDateTime.now();

        String consistentMessageId = "";
        String consistentComponentId = getComponent_ALFABET().getConsistentComponentID();
        String consistentProjectId = getCurrentProject("Alfabet").getConsistentProjectID();
        String version = getComponent_ALFABET().getVersion();
        Map<String, MessageView> views = new HashMap<String, MessageView>();

        messageRepository.insert(new Message(consistentMessageId, consistentComponentId, consistentProjectId, messageID, text, version, messageType, state, isForDocumentation, isForTranslation, views, user.getUsername(), date, user.getUsername(), date)); //insert into collection
        Message message = messageRepository.findByMessageID(messageID);
        message.setConsistentMessageID(message.getId());
        messageRepository.save(message);

        response.setHeader("Location","http://localhost:3000/messages");
        response.setStatus(302);
        return true;
    }

    @RequestMapping(value="/deleteMessage/{id}", method = RequestMethod.DELETE)
    public boolean deleteMessage(@PathVariable(name="id") String consistentMessageID, HttpServletResponse response) throws IOException {
        if(messageRepository.findByConsistentMessageID(consistentMessageID) == null){
            response.sendRedirect("http://localhost:3000/messages/" + consistentMessageID);
            return false;
        }
        User user = getCurrentUser("looo");
        if(!user.getUsername().equals(messageRepository.findByConsistentMessageID(consistentMessageID).getCreatedBy()))return false;
        messageRepository.delete(messageRepository.findByConsistentMessageID(consistentMessageID));
        response.sendRedirect("http://localhost:3000/messages/");
        return true;
    }

}