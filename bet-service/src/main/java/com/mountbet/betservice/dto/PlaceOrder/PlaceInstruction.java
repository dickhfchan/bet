package com.mountbet.betservice.dto.PlaceOrder;

import com.mountbet.betservice.constant.OrderType;
import com.mountbet.betservice.constant.Side;
import com.mountbet.betservice.dto.LimitOnCloseOrder;
import com.mountbet.betservice.dto.LimitOrder;
import com.mountbet.betservice.dto.MarketOnCloseOrder;

import java.io.Serializable;
import java.math.BigDecimal;

public class PlaceInstruction implements Serializable {
    private static final long serialVersionUID = 1L;

    private OrderType orderType;
    private Long selectionId;
    private BigDecimal handicap;
    private Side side;
    private LimitOrder limitOrder;
    private LimitOnCloseOrder limitOnCloseOrder;
    private MarketOnCloseOrder marketOnCloseOrder;
    private String customerOrderRef;

    public OrderType getOrderType() {
        return this.orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public Long getSelectionId() {
        return this.selectionId;
    }

    public void setSelectionId(Long selectionId) {
        this.selectionId = selectionId;
    }

    public BigDecimal getHandicap() {
        return this.handicap;
    }

    public void setHandicap(BigDecimal handicap) {
        this.handicap = handicap;
    }

    public Side getSide() {
        return this.side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public LimitOrder getLimitOrder() {
        return this.limitOrder;
    }

    public void setLimitOrder(LimitOrder limitOrder) {
        this.limitOrder = limitOrder;
    }

    public LimitOnCloseOrder getLimitOnCloseOrder() {
        return this.limitOnCloseOrder;
    }

    public void setLimitOnCloseOrder(LimitOnCloseOrder limitOnCloseOrder) {
        this.limitOnCloseOrder = limitOnCloseOrder;
    }

    public MarketOnCloseOrder getMarketOnCloseOrder() {
        return this.marketOnCloseOrder;
    }

    public void setMarketOnCloseOrder(MarketOnCloseOrder marketOnCloseOrder) {
        this.marketOnCloseOrder = marketOnCloseOrder;
    }

    public String getCustomerOrderRef() {
        return this.customerOrderRef;
    }

    public void setCustomerOrderRef(String customerOrderRef) {
        this.customerOrderRef = customerOrderRef;
    }

    @Override
    public String toString() {
        return "PlaceInstruction{" +
                "orderType=" + orderType +
                ", selectionId=" + selectionId +
                ", handicap=" + handicap +
                ", side=" + side +
                ", limitOrder=" + limitOrder +
                ", limitOnCloseOrder=" + limitOnCloseOrder +
                ", marketOnCloseOrder=" + marketOnCloseOrder +
                ", customerOrderRef='" + customerOrderRef + '\'' +
                '}';
    }
}