package com.mountbet.betservice.dto;

import javax.validation.constraints.NotNull;
import java.util.Set;

public class GetPastBetIdByEventTypeIdsDTO {
    private String selectColumns;

    private Set<String> state;

    private Set<String> eventTypeIdsSet;

    @NotNull
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

    public Set<String> getEventTypeIdsSet() {
        return eventTypeIdsSet;
    }

    public void setEventTypeIdsSet(Set<String> eventTypeIdsSet) {
        this.eventTypeIdsSet = eventTypeIdsSet;
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
        return "GetPastBetIdByEventTypeIdsDTO{" +
                "selectColumns='" + selectColumns + '\'' +
                ", state=" + state +
                ", eventTypeIdsSet=" + eventTypeIdsSet +
                ", accountId=" + accountId +
                ", timeRange=" + timeRange +
                '}';
    }
}
