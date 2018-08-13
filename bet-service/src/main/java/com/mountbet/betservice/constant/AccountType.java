package com.mountbet.betservice.constant;

public enum AccountType {
    SUPER_MASTER("Super master"),
    MASTER("Master"),
    SUB("Sub"),
    OPERATOR("Operator"),
    GAMING_PROVIDER("Gaming provider"),
    SUPER_ADMIN("Super admin"),
    ADMIN("Admin"),
    CASINO("Casino"),
    BET_TICKER("Bet ticker"),
    MANAGER("Manger"),
    JUNIOR_MANAGER("Junior manager"),
    PAYMENT_PROVIDER("Payment provider"),
    BETFAIR("Betfair");

    private String description;

    private AccountType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}