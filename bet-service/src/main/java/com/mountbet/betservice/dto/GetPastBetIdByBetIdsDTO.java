package com.mountbet.betservice.dto;

import java.util.Set;

public class GetPastBetIdByBetIdsDTO {
    String selectColumns;

    Set<String> state;

    java.util.Set<String> betIdsSet;

    Long accountId;

    TimeRange timeRange;

    public String getSelectColumns() {
        return selectColumns;
    }

    public void setSelectColumns(String selectColumns) {
        this.selectColumns = selectColumns;
    }

    public Set<String> getState() {
        return state;
    }

    public void setState(Set<String> state) {
        this.state = state;
    }

    public Set<String> getBetIdsSet() {
        return betIdsSet;
    }

    public void setBetIdsSet(Set<String> betIdsSet) {
        this.betIdsSet = betIdsSet;
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

    @Override
    public String toString() {
        return "GetPastBetIdByBetIdsDTO{" +
                "selectColumns='" + selectColumns + '\'' +
                ", state=" + state +
                ", betIdsSet=" + betIdsSet +
                ", accountId=" + accountId +
                ", timeRange=" + timeRange +
                '}';
    }
}
