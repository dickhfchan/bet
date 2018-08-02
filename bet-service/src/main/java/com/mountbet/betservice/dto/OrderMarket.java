package com.mountbet.betservice.dto;

public class OrderMarket {
    private String marketId;
    private OrderMarketSnap orderMarketSnap;
    private boolean isClosed;

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

    public OrderMarketSnap getOrderMarketSnap() {
        return orderMarketSnap;
    }

    public void setOrderMarketSnap(OrderMarketSnap orderMarketSnap) {
        this.orderMarketSnap = orderMarketSnap;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    @Override
    public String toString() {
        return "OrderMarket{" +
                "marketId='" + marketId + '\'' +
                ", orderMarketSnap=" + orderMarketSnap +
                ", isClosed=" + isClosed +
                '}';
    }
}