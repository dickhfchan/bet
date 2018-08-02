package com.mountbet.betservice.dto;

import com.mountbet.betservice.constant.Type;

public class SubscribeOrdersQueryRequest {
    private Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "SubscribeOrdersQueryRequest{" +
                "type='" + type + '\'' +
                '}';
    }
}