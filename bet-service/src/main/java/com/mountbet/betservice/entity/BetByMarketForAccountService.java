package com.mountbet.betservice.entity;

public class BetByMarketForAccountService extends BetByMarket {
    private Integer betCount;

    public Integer getBetCount() {
        return betCount;
    }

    public void setBetCount(Integer betCount) {
        this.betCount = betCount;
    }

    @Override
    public String toString() {
        return "BetByMarketForAccountService{" +
                "betCount=" + betCount +
                '}';
    }
}
