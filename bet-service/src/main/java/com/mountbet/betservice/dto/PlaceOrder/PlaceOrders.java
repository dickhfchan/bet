package com.mountbet.betservice.dto.PlaceOrder;

import java.io.Serializable;
import java.util.List;

public class PlaceOrders implements Serializable {
    private static final long serialVersionUID = 1L;

    protected String marketId;
    private List<PlaceInstruction> instructions;
    private String customerRef;

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

    public List<PlaceInstruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<PlaceInstruction> instructions) {
        this.instructions = instructions;
    }

    public String getCustomerRef() {
        return customerRef;
    }

    public void setCustomerRef(String customerRef) {
        this.customerRef = customerRef;
    }

    @Override
    public String toString() {
        return "PlaceOrders{" +
                "marketId='" + marketId + '\'' +
                ", instructions=" + instructions +
                ", customerRef='" + customerRef + '\'' +
                '}';
    }
}