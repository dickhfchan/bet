package com.mountbet.betservice.dto.ReplaceOrder;

import java.io.Serializable;
import java.util.List;

public class ReplaceExecutionReport implements Serializable {
    private static final long serialVersionUID = 1L;

    private String customerRef;
    private String status;
    private String errorCode;
    private String marketId;
    private List<ReplaceInstructionReport> instructionReports;

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

    public List<ReplaceInstructionReport> getInstructionReports() {
        return this.instructionReports;
    }

    public void setInstructionReports(List<ReplaceInstructionReport> instructionReports) {
        this.instructionReports = instructionReports;
    }

    @Override
    public String toString() {
        return "ReplaceExecutionReport{" +
                "customerRef='" + customerRef + '\'' +
                ", status='" + status + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", marketId='" + marketId + '\'' +
                ", instructionReports=" + instructionReports +
                '}';
    }
}