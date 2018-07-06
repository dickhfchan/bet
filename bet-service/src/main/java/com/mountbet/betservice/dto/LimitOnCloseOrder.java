package com.mountbet.betservice.dto;

public class LimitOnCloseOrder {
    private static final long serialVersionUID = 1L;

    private Double liability;
    private Double price;

    public Double getLiability() {
        return this.liability;
    }

    public void setLiability(Double liability) {
        this.liability = liability;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "LimitOnCloseOrder{" +
                "liability=" + liability +
                ", price=" + price +
                '}';
    }
}