package com.mountbet.betservice.dto;

public class MarketOnCloseOrder {
    private static final long serialVersionUID = 1L;

    private Double liability;

    public Double getLiability() {
        return this.liability;
    }

    public void setLiability(Double liability) {
        this.liability = liability;
    }

    @Override
    public String toString() {
        return "MarketOnCloseOrder{" +
                "liability=" + liability +
                '}';
    }
}