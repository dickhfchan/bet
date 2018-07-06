package com.mountbet.betservice.dto.CancelOrder;

import java.io.Serializable;
import java.util.Date;

public class CancelInstructionReport implements Serializable {
    private static final long serialVersionUID = 1L;

    private String status;
    private String errorCode;
    private CancelInstruction instruction;
    private Double sizeCancelled;
    private Date cancelledDate;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public CancelInstruction getInstruction() {
        return this.instruction;
    }

    public void setInstruction(CancelInstruction instruction) {
        this.instruction = instruction;
    }

    public Double getSizeCancelled() {
        return this.sizeCancelled;
    }

    public void setSizeCancelled(Double sizeCancelled) {
        this.sizeCancelled = sizeCancelled;
    }

    public Date getCancelledDate() {
        return this.cancelledDate;
    }

    public void setCancelledDate(Date cancelledDate) {
        this.cancelledDate = cancelledDate;
    }

    @Override
    public String toString() {
        return "CancelInstructionReport{" +
                "status='" + status + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", instruction=" + instruction +
                ", sizeCancelled=" + sizeCancelled +
                ", cancelledDate=" + cancelledDate +
                '}';
    }
}