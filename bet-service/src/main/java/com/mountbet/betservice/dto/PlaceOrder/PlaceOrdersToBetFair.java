package com.mountbet.betservice.dto.PlaceOrder;

import com.mountbet.betservice.constant.Type;

import java.io.Serializable;

public class PlaceOrdersToBetFair extends PlaceOrders implements Serializable {
    private static final long serialVersionUID = 1L;

    private Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "PlaceOrdersToBetFair{" +
                "type=" + type +
                "} " + super.toString();
    }
}