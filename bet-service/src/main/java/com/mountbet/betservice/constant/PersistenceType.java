package com.mountbet.betservice.constant;

public enum PersistenceType {
    LAPSE("Lapse the order at turn-in-play"),
    PERSIST("Persist the order to in-play"),
    MARKET_ON_CLOSE("Put the order into the auction (SP) at turn-in-play");

    private String description;

    private PersistenceType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
