package com.mountbet.betservice.dto.PlaceOrder;

import com.mountbet.betservice.constant.OrderStatus;

import java.io.Serializable;
import java.util.Date;

public class PlaceInstructionReport implements Serializable {
    private static final long serialVersionUID = 1L;

    private String status;
    private String errorCode;
    private OrderStatus orderStatus;
    private PlaceInstruction instruction;
    private String betId;
    private Date placedDate;
    private Double averagePriceMatched;
    private Double sizeMatched;

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

    public OrderStatus getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public PlaceInstruction getInstruction() {
        return this.instruction;
    }

    public void setInstruction(PlaceInstruction instruction) {
        this.instruction = instruction;
    }

    public String getBetId() {
        return this.betId;
    }

    public void setBetId(String betId) {
        this.betId = betId;
    }

    public Date getPlacedDate() {
        return this.placedDate;
    }

    public void setPlacedDate(Date placedDate) {
        this.placedDate = placedDate;
    }

    public Double getAveragePriceMatched() {
        return this.averagePriceMatched;
    }

    public void setAveragePriceMatched(Double averagePriceMatched) {
        this.averagePriceMatched = averagePriceMatched;
    }

    public Double getSizeMatched() {
        return this.sizeMatched;
    }

    public void setSizeMatched(Double sizeMatched) {
        this.sizeMatched = sizeMatched;
    }

    @Override
    public String toString() {
        return "PlaceInstructionReport{" +
                "status='" + status + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", orderStatus=" + orderStatus +
                ", instruction=" + instruction +
                ", betId='" + betId + '\'' +
                ", placedDate=" + placedDate +
                ", averagePriceMatched=" + averagePriceMatched +
                ", sizeMatched=" + sizeMatched +
                '}';
    }
}
