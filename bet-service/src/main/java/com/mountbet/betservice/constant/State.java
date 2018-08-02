package com.mountbet.betservice.constant;

public enum State {
    MATCHED("Matched"),
    UNMATCHED("Unmatched"),
    WON("Won"),
    LOST("Lost"),
    CANCELLED("Cancelled"),
    LAPSED("Lapsed"),
    VOIDED("Voided");

    private String description;

    private State(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
