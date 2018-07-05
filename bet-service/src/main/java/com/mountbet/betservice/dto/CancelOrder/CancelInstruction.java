package com.mountbet.betservice.dto.CancelOrder;

import java.io.Serializable;
import java.math.BigDecimal;

public class CancelInstruction implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long betId;
    private BigDecimal sizeReduction;

    public Long getBetId() {
        return this.betId;
    }

    public void setBetId(Long betId) {
        this.betId = betId;
    }

    public BigDecimal getSizeReduction() {
        return this.sizeReduction;
    }

    public void setSizeReduction(BigDecimal sizeReduction) {
        this.sizeReduction = sizeReduction;
    }

    @Override
    public String toString() {
        return "CancelInstruction{" +
                "betId='" + betId + '\'' +
                ", sizeReduction=" + sizeReduction +
                '}';
    }
}