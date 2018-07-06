package com.mountbet.betservice.dto.CancelOrder;

import java.io.Serializable;
import java.util.List;

public class CancelExecutionReport implements Serializable {
    private static final long serialVersionUID = 1L;

    private String customerRef;
    private String status;
    private String errorCode;
    private String marketId;
    private List<CancelInstructionReport> instructionReports;

    public String getCustomerRef() {
        return this.customerRef;
    }

    public void setCustomerRef(String customerRef) {
        this.customerRef = customerRef;
    }

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

    public String getMarketId() {
        return this.marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

    public List<CancelInstructionReport> getInstructionReports() {
        return this.instructionReports;
    }

    public void setInstructionReports(List<CancelInstructionReport> instructionReports) {
        this.instructionReports = instructionReports;
    }

    @Override
    public String toString() {
        return "CancelExecutionReport{" +
                "customerRef='" + customerRef + '\'' +
                ", status='" + status + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", marketId='" + marketId + '\'' +
                ", instructionReports=" + instructionReports +
                '}';
    }
}