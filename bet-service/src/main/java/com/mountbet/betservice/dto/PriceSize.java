package com.mountbet.betservice.dto;

public class PriceSize {
    private double price;
    private double size;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "PriceSize{" +
                "price=" + price +
                ", size=" + size +
                '}';
    }
}