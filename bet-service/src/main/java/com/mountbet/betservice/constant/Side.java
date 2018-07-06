package com.mountbet.betservice.constant;

public enum Side {
    BACK("To back a team, horse or outcome is to bet on the selection to win."),
    LAY("To lay a team, horse, or outcome is to bet on the selection to lose.");

    private String description;

    private Side(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
