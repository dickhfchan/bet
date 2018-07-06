package com.mountbet.betservice.dto.PlaceOrder;

import java.io.Serializable;
import java.util.List;

public class PlaceExecutionReport implements Serializable {
    private static final long serialVersionUID = 1L;

    private String customerRef;
    private String status;
    private String errorCode;
    private String marketId;
    private List<PlaceInstructionReport> instructionReports;

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

    public List<PlaceInstructionReport> getInstructionReports() {
        return this.instructionReports;
    }

    public void setInstructionReports(List<PlaceInstructionReport> instructionReports) {
        this.instructionReports = instructionReports;
    }

    @Override
    public String toString() {
        return "PlaceExecutionReport{" +
                "customerRef='" + customerRef + '\'' +
                ", status='" + status + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", marketId='" + marketId + '\'' +
                ", instructionReports=" + instructionReports +
                '}';
    }
}