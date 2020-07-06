package com.server.model;

public enum EntityState {
    NEW("new"),
    MODIFIED("modified"),
    TRANSLATED("translated"),
    REMOVED("removed");

    private final String id;

    public String getId() {
        return id;
    }

    EntityState(String id) {
        this.id = id;
    }
}
