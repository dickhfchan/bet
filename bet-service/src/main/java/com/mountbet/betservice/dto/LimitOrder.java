package com.mountbet.betservice.dto;

import com.mountbet.betservice.constant.BetTargetType;
import com.mountbet.betservice.constant.PersistenceType;
import com.mountbet.betservice.constant.TimeInForce;

import java.math.BigDecimal;

public class LimitOrder {
    private static final long serialVersionUID = 1L;

    private BigDecimal size;
    private BigDecimal price;
    private PersistenceType persistenceType;
    private TimeInForce timeInForce;
    private Double minFillSize;
    private BetTargetType betTargetType;
    private Double betTargetSize;

    public BigDecimal getSize() {
        return this.size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public PersistenceType getPersistenceType() {
        return this.persistenceType;
    }

    public void setPersistenceType(PersistenceType persistenceType) {
        this.persistenceType = persistenceType;
    }

    public TimeInForce getTimeInForce() {
        return this.timeInForce;
    }

    public void setTimeInForce(TimeInForce timeInForce) {
        this.timeInForce = timeInForce;
    }

    public Double getMinFillSize() {
        return this.minFillSize;
    }

    public void setMinFillSize(Double minFillSize) {
        this.minFillSize = minFillSize;
    }

    public BetTargetType getBetTargetType() {
        return this.betTargetType;
    }

    public void setBetTargetType(BetTargetType betTargetType) {
        this.betTargetType = betTargetType;
    }

    public Double getBetTargetSize() {
        return this.betTargetSize;
    }

    public void setBetTargetSize(Double betTargetSize) {
        this.betTargetSize = betTargetSize;
    }

    @Override
    public String toString() {
        return "LimitOrder{" +
                "size=" + size +
                ", price=" + price +
                ", persistenceType=" + persistenceType +
                ", timeInForce=" + timeInForce +
                ", minFillSize=" + minFillSize +
                ", betTargetType=" + betTargetType +
                ", betTargetSize=" + betTargetSize +
                '}';
    }
}