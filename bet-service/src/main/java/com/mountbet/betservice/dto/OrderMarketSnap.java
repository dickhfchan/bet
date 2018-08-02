package com.mountbet.betservice.dto;

import java.util.List;

public class OrderMarketSnap {
    private String marketId;
    private boolean isClosed;
    private List<OrderMarketRunnerSnap> orderMarketRunners;

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public List<OrderMarketRunnerSnap> getOrderMarketRunners() {
        return orderMarketRunners;
    }

    public void setOrderMarketRunners(List<OrderMarketRunnerSnap> orderMarketRunners) {
        this.orderMarketRunners = orderMarketRunners;
    }

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

    @Override
    public String toString() {
        return "OrderMarketSnap{" +
                "marketId='" + marketId + '\'' +
                ", isClosed=" + isClosed +
                ", orderMarketRunners=" + orderMarketRunners +
                '}';
    }
}
