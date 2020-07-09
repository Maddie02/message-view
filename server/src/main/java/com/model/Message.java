package com.model;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "messages_ALF")
public class Message {
    
    @Id
    private String id;

    private String consistentMessageID;
    private String consistentComponentID;
    private String consistentProjectID;
    private String messageID;
    private String text;
    private String version;
    private String messageType;
    private EntityState state;
    private boolean forDocumentation;
    private boolean forTranslation;
    private String createdBy;
    private LocalDateTime createdDate;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;
    private Map<String, MessageView> views;

    public Message(String consistentMessageID, String consistentComponentID, String consistentProjectID,
        String messageID, String text, String version, String messageType, EntityState state, boolean forDocumentation,
        boolean forTranslation, Map<String, MessageView> views, String createdBy, LocalDateTime createdDate, String lastModifiedBy, LocalDateTime lastModifiedDate) {
        this.consistentMessageID = consistentMessageID;
        this.consistentComponentID = consistentComponentID;
        this.consistentProjectID = consistentProjectID;
        this.messageID = messageID;
        this.text = text;
        this.version = version;
        this.messageType = messageType;
        this.state = state;
        this.forDocumentation = forDocumentation;
        this.forTranslation = forTranslation;
        this.views = views;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getId() {
        return id;
    }

    public String getConsistentComponentID() {
        return consistentComponentID;
    }

    public String getConsistentMessageID() {
        return consistentMessageID;
    }

    public String getConsistentProjectID() {
        return consistentProjectID;
    }

    public String getMessageID() {
        return messageID;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMessageType() {
        return this.messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public EntityState getState() {
        return this.state;
    }

    public void setState(EntityState state) {
        this.state = state;
    }

    public boolean isForDocumentation() {
        return this.forDocumentation;
    }

    public boolean getForDocumentation() {
        return this.forDocumentation;
    }

    public void setForDocumentation(boolean forDocumentation) {
        this.forDocumentation = forDocumentation;
    }

    public boolean isForTranslation() {
        return this.forTranslation;
    }

    public boolean getForTranslation() {
        return this.forTranslation;
    }

    public void setForTranslation(boolean forTranslation) {
        this.forTranslation = forTranslation;
    }

    public Map<String, MessageView> getViews() {
        return this.views;
    }

    public void setViews(Map<String, MessageView> views) {
        this.views = views;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return this.lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public LocalDateTime getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
    
    public void setConsistentMessageID(String consistentMessageID) {
        this.consistentMessageID = consistentMessageID;
    }
}