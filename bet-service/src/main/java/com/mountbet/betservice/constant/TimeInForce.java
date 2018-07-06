package com.mountbet.betservice.constant;

public enum TimeInForce {
    FILL_OR_KILL("Execute the transaction immediately and completely (filled to size or between minFillSize and size) or not at all (cancelled)");

    private String description;

    private TimeInForce(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
