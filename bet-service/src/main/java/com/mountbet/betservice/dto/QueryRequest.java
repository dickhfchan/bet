package com.mountbet.betservice.dto;

import com.mountbet.betservice.constant.Type;

public class QueryRequest {

    private Type customerRef;

    public Type getCustomerRef() {
        return customerRef;
    }

    public void setCustomerRef(Type customerRef) {
        this.customerRef = customerRef;
    }

    @Override
    public String toString() {
        return "QueryRequest{" +
                "customerRef=" + customerRef +
                '}';
    }
}
