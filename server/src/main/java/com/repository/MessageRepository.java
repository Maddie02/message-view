package com.repository;

import com.model.Message;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends MongoRepository<Message, String> {
    public Message findByMessageID(String messageID);
    public Message findByConsistentMessageID(String consistentMessageID);
}