package com.mountbet.betservice.dto.ReplaceOrder;

import java.io.Serializable;
import java.math.BigDecimal;

public class ReplaceInstruction implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long betId;
    private BigDecimal newPrice;

    public Long getBetId() {
        return this.betId;
    }

    public void setBetId(Long betId) {
        this.betId = betId;
    }

    public BigDecimal getNewPrice() {
        return this.newPrice;
    }

    public void setNewPrice(BigDecimal newPrice) {
        this.newPrice = newPrice;
    }

    @Override
    public String toString() {
        return "ReplaceInstruction{" +
                "betId='" + betId + '\'' +
                ", newPrice=" + newPrice +
                '}';
    }
}