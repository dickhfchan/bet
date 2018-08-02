package com.mountbet.betservice.constant;

public enum Status {
    CURRENT("Current bet"),
    PAST("Past bet");

    private String description;

    private Status(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
