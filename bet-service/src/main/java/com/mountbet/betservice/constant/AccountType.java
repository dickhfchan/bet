package com.mountbet.betservice.constant;

public enum AccountType {
    SUPER_MASTER("Super master"),
    MASTER("Master"),
    SUB("Sub");

    private String description;

    private AccountType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}