package com.mountbet.betservice.dto;

import java.util.List;

public class OrderChanged {
    private boolean isOrderMarketRemovedOnClose;
    private List<OrderMarket> orderMarkets;
    private int numberOfOrderMarkets;

    public boolean isOrderMarketRemovedOnClose() {
        return isOrderMarketRemovedOnClose;
    }

    public void setOrderMarketRemovedOnClose(boolean orderMarketRemovedOnClose) {
        isOrderMarketRemovedOnClose = orderMarketRemovedOnClose;
    }

    public List<OrderMarket> getOrderMarkets() {
        return orderMarkets;
    }

    public void setOrderMarkets(List<OrderMarket> orderMarkets) {
        this.orderMarkets = orderMarkets;
    }

    public int getNumberOfOrderMarkets() {
        return numberOfOrderMarkets;
    }

    public void setNumberOfOrderMarkets(int numberOfOrderMarkets) {
        this.numberOfOrderMarkets = numberOfOrderMarkets;
    }

    @Override
    public String toString() {
        return "OrderChanged{" +
                "isOrderMarketRemovedOnClose=" + isOrderMarketRemovedOnClose +
                ", orderMarkets=" + orderMarkets +
                ", numberOfOrderMarkets=" + numberOfOrderMarkets +
                '}';
    }
}