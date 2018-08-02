package com.mountbet.betservice.dto;

import java.util.List;

public class NavigationDetail {
    private Long eventTypeId;
    private Long eventId;
    private Long competitionId;
    private String marketId;
    private String eventTypeName;
    private String eventName;
    private String competitionName;
    private String marketName;
    private List<SelectionDetail> selections;

    public Long getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(Long eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(Long competitionId) {
        this.competitionId = competitionId;
    }

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

    public String getEventTypeName() {
        return eventTypeName;
    }

    public void setEventTypeName(String eventTypeName) {
        this.eventTypeName = eventTypeName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public List<SelectionDetail> getSelections() {
        return selections;
    }

    public void setSelections(List<SelectionDetail> selections) {
        this.selections = selections;
    }

    @Override
    public String toString() {
        return "NavigationDetail{" +
                "eventTypeId=" + eventTypeId +
                ", eventId=" + eventId +
                ", competitionId=" + competitionId +
                ", marketId='" + marketId + '\'' +
                ", eventTypeName='" + eventTypeName + '\'' +
                ", eventName='" + eventName + '\'' +
                ", competitionName='" + competitionName + '\'' +
                ", marketName='" + marketName + '\'' +
                ", selections=" + selections +
                '}';
    }
}