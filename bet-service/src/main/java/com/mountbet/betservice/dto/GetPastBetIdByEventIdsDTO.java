package com.mountbet.betservice.dto;

import java.util.Set;

public class GetPastBetIdByEventIdsDTO {
    private String selectColumns;

    private Set<String> state;

    private java.util.Set<String> eventIdsSet;

    private Long accountId;

    private TimeRange timeRange;

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

    public Set<String> getEventIdsSet() {
        return eventIdsSet;
    }

    public void setEventIdsSet(Set<String> eventIdsSet) {
        this.eventIdsSet = eventIdsSet;
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
        return "GetPastBetIdByEventIdsDTO{" +
                "selectColumns='" + selectColumns + '\'' +
                ", state=" + state +
                ", eventIdsSet=" + eventIdsSet +
                ", accountId=" + accountId +
                ", timeRange=" + timeRange +
                '}';
    }
}
