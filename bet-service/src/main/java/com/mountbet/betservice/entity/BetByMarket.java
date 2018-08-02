package com.mountbet.betservice.entity;

import com.datastax.driver.core.DataType;
import com.mountbet.betservice.constant.PersistenceType;
import com.mountbet.betservice.entity.key.BetByMarketKey;
import com.mountbet.betservice.entity.udt.RiskDetail;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

@Table(value = "bet_by_market")
public class BetByMarket {
    @PrimaryKey
    private BetByMarketKey key;

    @Column(value = "price")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal price = new BigDecimal(0.0);

    @Column(value = "handicap")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal handicap = new BigDecimal(0.0);

    @Column(value = "absolute_ex_rate")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal absoluteExchangeRate = new BigDecimal(0.0);

    @Column(value = "persistence_type")
    @CassandraType(type = DataType.Name.TEXT)
    private PersistenceType persistenceType;

    @Column(value = "placed_ip")
    @CassandraType(type = DataType.Name.TEXT)
    private String placedIp;

    @Column(value = "average_size_matched")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal averageSizeMatched = new BigDecimal(0.0);

    @Column(value = "size")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal size = new BigDecimal(0.0);

    @Column(value = "size_placed")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal sizePlaced = new BigDecimal(0.0);

    @Column(value = "size_matched")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal sizeMatched = new BigDecimal(0.0);

    @Column(value = "size_cancelled")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal sizeCancelled = new BigDecimal(0.0);

    @Column(value = "size_remaining")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal sizeRemaining = new BigDecimal(0.0);

    @Column(value = "size_lapsed")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal sizeLapsed = new BigDecimal(0.0);

    @Column(value = "size_voided")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal sizeVoided = new BigDecimal(0.0);

    @Column(value = "matched_date")
    @CassandraType(type = DataType.Name.TIMESTAMP)
    private Date matchedDate;

    @Column(value = "cancelled_date")
    @CassandraType(type = DataType.Name.TIMESTAMP)
    private Date cancelledDate;

    @Column(value = "settled_date")
    @CassandraType(type = DataType.Name.TIMESTAMP)
    private Date settledDate;

    @Column(value = "risk_coefficient")
    @CassandraType(type = DataType.Name.MAP, typeArguments = {DataType.Name.BIGINT, DataType.Name.DECIMAL})
    private Map<Long, BigDecimal> riskCoefficient;

    @Column(value = "risk_detail")
    @CassandraType(type = DataType.Name.UDT, userTypeName = "risk_detail")
    private RiskDetail riskDetail;

    public BetByMarketKey getKey() {
        return key;
    }

    public void setKey(BetByMarketKey key) {
        this.key = key;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getHandicap() {
        return handicap;
    }

    public void setHandicap(BigDecimal handicap) {
        this.handicap = handicap;
    }

    public BigDecimal getAbsoluteExchangeRate() {
        return absoluteExchangeRate;
    }

    public void setAbsoluteExchangeRate(BigDecimal absoluteExchangeRate) {
        this.absoluteExchangeRate = absoluteExchangeRate;
    }

    public PersistenceType getPersistenceType() {
        return persistenceType;
    }

    public void setPersistenceType(PersistenceType persistenceType) {
        this.persistenceType = persistenceType;
    }

    public String getPlacedIp() {
        return placedIp;
    }

    public void setPlacedIp(String placedIp) {
        this.placedIp = placedIp;
    }

    public BigDecimal getAverageSizeMatched() {
        return averageSizeMatched;
    }

    public void setAverageSizeMatched(BigDecimal averageSizeMatched) {
        this.averageSizeMatched = averageSizeMatched;
    }

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }

    public BigDecimal getSizePlaced() {
        return sizePlaced;
    }

    public void setSizePlaced(BigDecimal sizePlaced) {
        this.sizePlaced = sizePlaced;
    }

    public BigDecimal getSizeMatched() {
        return sizeMatched;
    }

    public void setSizeMatched(BigDecimal sizeMatched) {
        this.sizeMatched = sizeMatched;
    }

    public BigDecimal getSizeCancelled() {
        return sizeCancelled;
    }

    public void setSizeCancelled(BigDecimal sizeCancelled) {
        this.sizeCancelled = sizeCancelled;
    }

    public BigDecimal getSizeRemaining() {
        return sizeRemaining;
    }

    public void setSizeRemaining(BigDecimal sizeRemaining) {
        this.sizeRemaining = sizeRemaining;
    }

    public BigDecimal getSizeLapsed() {
        return sizeLapsed;
    }

    public void setSizeLapsed(BigDecimal sizeLapsed) {
        this.sizeLapsed = sizeLapsed;
    }

    public BigDecimal getSizeVoided() {
        return sizeVoided;
    }

    public void setSizeVoided(BigDecimal sizeVoided) {
        this.sizeVoided = sizeVoided;
    }

    public Date getMatchedDate() {
        return matchedDate;
    }

    public void setMatchedDate(Date matchedDate) {
        this.matchedDate = matchedDate;
    }

    public Date getCancelledDate() {
        return cancelledDate;
    }

    public void setCancelledDate(Date cancelledDate) {
        this.cancelledDate = cancelledDate;
    }

    public Date getSettledDate() {
        return settledDate;
    }

    public void setSettledDate(Date settledDate) {
        this.settledDate = settledDate;
    }

    public Map<Long, BigDecimal> getRiskCoefficient() {
        return riskCoefficient;
    }

    public void setRiskCoefficient(Map<Long, BigDecimal> riskCoefficient) {
        this.riskCoefficient = riskCoefficient;
    }

    public RiskDetail getRiskDetail() {
        return riskDetail;
    }

    public void setRiskDetail(RiskDetail riskDetail) {
        this.riskDetail = riskDetail;
    }

    @Override
    public String toString() {
        return "BetByMarket{" +
                "key=" + key +
                ", price=" + price +
                ", handicap=" + handicap +
                ", absoluteExchangeRate=" + absoluteExchangeRate +
                ", persistenceType=" + persistenceType +
                ", placedIp='" + placedIp + '\'' +
                ", averageSizeMatched='" + averageSizeMatched + '\'' +
                ", size=" + size +
                ", sizePlaced=" + sizePlaced +
                ", sizeMatched=" + sizeMatched +
                ", sizeCancelled=" + sizeCancelled +
                ", sizeRemaining=" + sizeRemaining +
                ", sizeLapsed=" + sizeLapsed +
                ", sizeVoided=" + sizeVoided +
                ", matchedDate=" + matchedDate +
                ", cancelledDate=" + cancelledDate +
                ", settledDate=" + settledDate +
                ", riskCoefficient=" + riskCoefficient +
                ", riskDetail=" + riskDetail +
                '}';
    }
}