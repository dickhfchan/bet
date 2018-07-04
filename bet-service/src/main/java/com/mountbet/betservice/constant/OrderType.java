package com.mountbet.betservice.constant;

public enum OrderType {
    LIMIT("A normal exchange limit order for immediate execution"),
    LIMIT_ON_CLOSE("Limit order for the auction (SP)"),
    MARKET_ON_CLOSE("Market order for the auction (SP)");

    private String description;

    private OrderType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
