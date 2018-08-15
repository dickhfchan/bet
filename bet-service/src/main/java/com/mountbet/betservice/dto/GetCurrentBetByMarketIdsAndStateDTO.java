package com.mountbet.betservice.dto;

import com.mountbet.betservice.constant.OrderProjection;

import java.util.Set;

public class GetCurrentBetByMarketIdsAndStateDTO {
    private Set<String> marketIdsSet;

    private Long accountId;

    private TimeRange timeRange;

    private OrderProjection orderProjection;

    public Set<String> getMarketIdsSet() {
        return marketIdsSet;
    }

    public void setMarketIdsSet(Set<String> marketIdsSet) {
        this.marketIdsSet = marketIdsSet;
    }

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
        return "GetCurrentBetByMarketIdsAndStateDTO{" +
                "marketIdsSet=" + marketIdsSet +
                ", accountId=" + accountId +
                ", timeRange=" + timeRange +
                ", orderProjection=" + orderProjection +
                '}';
    }
}
