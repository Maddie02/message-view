/*
 * Copyright (c) 2019-2020 Software AG, Darmstadt, Germany and/or Software AG USA Inc., Reston, VA, USA, and/or its
 * subsidiaries and/or its affiliates and/or their licensors.
 *
 * Use, reproduction, transfer, publication or disclosure is prohibited except as specifically provided for in your
 * License Agreement with Software AG.
 */
package com.server.model;

import java.time.LocalDateTime;

/**
 * Model of a message view. Each message has a separate view for every language
 * it is translated into.
 * for example:
 * views: {
 * "de" : {"text", "Hallo", "action" : "etwas tun"...},
 * "es" : {"text", "Hola", "action" : "di hola"...}
 * }
 */
public class MessageView {

    private String text;
    private String reviewedBy;
    private LocalDateTime revisionDate;
    private String explanation;
    private String action;
    private EntityState state;

    public MessageView() {
    }

    public MessageView(String text, String action, EntityState state) {
        this.text = text;
        this.action = action;
        this.state = state;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getReviewedBy() {
        return reviewedBy;
    }

    public void setReviewedBy(String reviewedBy) {
        this.reviewedBy = reviewedBy;
    }

    public LocalDateTime getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(LocalDateTime revisionDate) {
        this.revisionDate = revisionDate;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public EntityState getState() {
        return state;
    }

    public void setState(EntityState state) {
        this.state = state;
    }
}
