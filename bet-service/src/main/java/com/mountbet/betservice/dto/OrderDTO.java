package com.mountbet.betservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OrderDTO {
    @JsonProperty("type")
    private String type;
    @JsonProperty("bets")
    private List<BetUpdate> betUpdates;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<BetUpdate> getBetUpdates() {
        return betUpdates;
    }

    public void setBetUpdates(List<BetUpdate> betUpdates) {
        this.betUpdates = betUpdates;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "type='" + type + '\'' +
                ", betUpdates=" + betUpdates +
                '}';
    }
}