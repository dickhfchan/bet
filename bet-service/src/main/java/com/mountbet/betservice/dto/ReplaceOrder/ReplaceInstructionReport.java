package com.mountbet.betservice.dto.ReplaceOrder;

import com.mountbet.betservice.dto.CancelOrder.CancelInstructionReport;
import com.mountbet.betservice.dto.PlaceOrder.PlaceInstructionReport;

import java.io.Serializable;

public class ReplaceInstructionReport implements Serializable {
    private static final long serialVersionUID = 1L;

    private String status;
    private String errorCode;
    private CancelInstructionReport cancelInstructionReport;
    private PlaceInstructionReport placeInstructionReport;

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

    public CancelInstructionReport getCancelInstructionReport() {
        return this.cancelInstructionReport;
    }

    public void setCancelInstructionReport(CancelInstructionReport cancelInstructionReport) {
        this.cancelInstructionReport = cancelInstructionReport;
    }

    public PlaceInstructionReport getPlaceInstructionReport() {
        return this.placeInstructionReport;
    }

    public void setPlaceInstructionReport(PlaceInstructionReport placeInstructionReport) {
        this.placeInstructionReport = placeInstructionReport;
    }

    @Override
    public String toString() {
        return "ReplaceInstructionReport{" +
                "status='" + status + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", cancelInstructionReport=" + cancelInstructionReport +
                ", placeInstructionReport=" + placeInstructionReport +
                '}';
    }
}