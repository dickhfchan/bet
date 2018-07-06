package com.mountbet.betservice.dto.UpdateOrder;

import com.mountbet.betservice.constant.PersistenceType;

public class UpdateInstruction {
    private static final long serialVersionUID = 1L;

    private Long betId;
    private PersistenceType newPersistenceType;

    public Long getBetId() {
        return this.betId;
    }

    public void setBetId(Long betId) {
        this.betId = betId;
    }

    public PersistenceType getNewPersistenceType() {
        return this.newPersistenceType;
    }

    public void setNewPersistenceType(PersistenceType newPersistenceType) {
        this.newPersistenceType = newPersistenceType;
    }

    @Override
    public String toString() {
        return "UpdateInstruction{" +
                "betId='" + betId + '\'' +
                ", newPersistenceType=" + newPersistenceType +
                '}';
    }
}