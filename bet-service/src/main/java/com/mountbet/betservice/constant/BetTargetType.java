package com.mountbet.betservice.constant;

public enum BetTargetType {
    PAYOUT("The total payout requested on a LimitOrder"),
    BACKERS_PROFIT("The payout requested minus the calculated size at which this LimitOrder is to be placed");

    private String description;

    private BetTargetType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
