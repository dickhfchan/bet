package com.mountbet.betservice.dto;

import com.mountbet.betservice.constant.OrderProjection;

public class GetCurrentBetByStateDTO {
    private Long accountId;

    private TimeRange timeRange;

    private OrderProjection orderProjection;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public TimeRange getTimeRange() {
        return timeRange;
    }

    public void setTimeRange(TimeRange timeRange) {
        this.timeRange = timeRange;
    }

    public OrderProjection getOrderProjection() {
        return orderProjection;
    }

    public void setOrderProjection(OrderProjection orderProjection) {
        this.orderProjection = orderProjection;
    }

    @Override
    public String toString() {
        return "GetCurrentBetByStateDTO{" +
                "accountId=" + accountId +
                ", timeRange=" + timeRange +
                ", orderProjection=" + orderProjection +
                '}';
    }
}
