package com.mountbet.betservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mountbet.betservice.constant.PersistenceType;
import com.mountbet.betservice.constant.Side;

import java.math.BigDecimal;
import java.util.Date;

public class BetUpdate {
    @JsonProperty("id")
    private Long betId;
    @JsonProperty("mid")
    private String marketId;
    @JsonProperty("sid")
    private Long selectionId;
    @JsonProperty("h")
    private BigDecimal handicap;
    @JsonProperty("p")
    private BigDecimal price;
    @JsonProperty("s")
    private BigDecimal size;
    @JsonProperty("sd")
    private Side side;
    @JsonProperty("pt")
    private PersistenceType persistenceType;
    @JsonProperty("pd")
    private Date placedDate;
    @JsonProperty("apm")
    private BigDecimal averagePriceMatched;
    @JsonProperty("sm")
    private BigDecimal sizeMatched;
    @JsonProperty("sr")
    private BigDecimal sizeRemained;
    @JsonProperty("u")
    private Long user;
    @JsonProperty("md")
    private Date matchedDate;
    @JsonProperty("sl")
    private BigDecimal sizeLapsed;
    @JsonProperty("sc")
    private BigDecimal sizeCancelled;
    @JsonProperty("sv")
    private BigDecimal sizeVoided;
    @JsonProperty("cl")
    private Boolean cleared;

    public Long getBetId() {
        return betId;
    }

    public void setBetId(Long betId) {
        this.betId = betId;
    }

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

    public Long getSelectionId() {
        return selectionId;
    }

    public void setSelectionId(Long selectionId) {
        this.selectionId = selectionId;
    }

    public BigDecimal getHandicap() {
        return handicap;
    }

    public void setHandicap(BigDecimal handicap) {
        this.handicap = handicap;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public PersistenceType getPersistenceType() {
        return persistenceType;
    }

    public void setPersistenceType(PersistenceType persistenceType) {
        this.persistenceType = persistenceType;
    }

    public Date getPlacedDate() {
        return placedDate;
    }

    public void setPlacedDate(Date placedDate) {
        this.placedDate = placedDate;
    }

    public BigDecimal getAveragePriceMatched() {
        return averagePriceMatched;
    }

    public void setAveragePriceMatched(BigDecimal averagePriceMatched) {
        this.averagePriceMatched = averagePriceMatched;
    }

    public BigDecimal getSizeMatched() {
        return sizeMatched;
    }

    public void setSizeMatched(BigDecimal sizeMatched) {
        this.sizeMatched = sizeMatched;
    }

    public BigDecimal getSizeRemained() {
        return sizeRemained;
    }

    public void setSizeRemained(BigDecimal sizeRemained) {
        this.sizeRemained = sizeRemained;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public Date getMatchedDate() {
        return matchedDate;
    }

    public void setMatchedDate(Date matchedDate) {
        this.matchedDate = matchedDate;
    }

    public BigDecimal getSizeLapsed() {
        return sizeLapsed;
    }

    public void setSizeLapsed(BigDecimal sizeLapsed) {
        this.sizeLapsed = sizeLapsed;
    }

    public BigDecimal getSizeCancelled() {
        return sizeCancelled;
    }

    public void setSizeCancelled(BigDecimal sizeCancelled) {
        this.sizeCancelled = sizeCancelled;
    }

    public BigDecimal getSizeVoided() {
        return sizeVoided;
    }

    public void setSizeVoided(BigDecimal sizeVoided) {
        this.sizeVoided = sizeVoided;
    }

    public Boolean getCleared() {
        return cleared;
    }

    public void setCleared(Boolean cleared) {
        this.cleared = cleared;
    }

    @Override
    public String toString() {
        return "BetUpdate{" +
                "betId=" + betId +
                ", marketId='" + marketId + '\'' +
                ", selectionId=" + selectionId +
                ", handicap=" + handicap +
                ", price=" + price +
                ", size=" + size +
                ", side=" + side +
                ", persistenceType=" + persistenceType +
                ", placedDate=" + placedDate +
                ", averagePriceMatched=" + averagePriceMatched +
                ", sizeMatched=" + sizeMatched +
                ", sizeRemained=" + sizeRemained +
                ", user='" + user + '\'' +
                ", matchedDate=" + matchedDate +
                ", sizeLapsed=" + sizeLapsed +
                ", sizeCancelled=" + sizeCancelled +
                ", sizeVoided=" + sizeVoided +
                ", cleared=" + cleared +
                '}';
    }
}