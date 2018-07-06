package com.mountbet.betservice.entity;

import com.datastax.driver.core.DataType;
import com.mountbet.betservice.constant.PersistenceType;
import com.mountbet.betservice.constant.Side;
import com.mountbet.betservice.entity.key.BetByMarket.BetByMarketKey;
import com.mountbet.betservice.entity.udt.BetByMarket.BetByMarketPlaceOrderRiskDetail;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * @author AnsonChan
 * @since 28/6/2018
 */
@Table(value = "bet_by_market")
public class BetByMarket {
    @PrimaryKey
    private BetByMarketKey key;

    @Column(value = "absolute_ex_rate")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal absoluteExRate;

    @Column(value = "account_id")
    @CassandraType(type = DataType.Name.BIGINT)
    private Long accountId;

    @Column(value = "avg_price_matched")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal avgPriceMatched;

    @Column(value = "bet_id")
    @CassandraType(type = DataType.Name.BIGINT)
    private Long betId;

    @Column(value = "cancelled_date")
    @CassandraType(type = DataType.Name.TIMESTAMP)
    private Date cancelledDate;

    @Column(value = "handicap")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal handicap;

    @Column(value = "market_betting_type")
    @CassandraType(type = DataType.Name.INT)
    private Integer marketBettingType;

    @Column(value = "matched_date")
    @CassandraType(type = DataType.Name.TIMESTAMP)
    private Date matchedDate;

    @Column(value = "partner_id")
    @CassandraType(type = DataType.Name.INT)
    private Integer partnerId;

    @Column(value = "persistence_type")
    @CassandraType(type = DataType.Name.TEXT)
    private PersistenceType persistenceType;

    @Column(value = "placed_date")
    @CassandraType(type = DataType.Name.TIMESTAMP)
    private Date placedDate;

    @Column(value = "placed_ip")
    @CassandraType(type = DataType.Name.TEXT)
    private String placedIp;

    @Column(value = "price")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal price;

    @Column(value = "profit")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal profit;

    @Column(value = "risk_ceofficient")
    @CassandraType(type = DataType.Name.MAP, typeArguments = {DataType.Name.BIGINT, DataType.Name.DECIMAL})
    private Map<Long, BigDecimal> riskCeofficient;

    @Column(value = "risk_detail")
    @CassandraType(type = DataType.Name.UDT, userTypeName = "place_order_risk_detail")
    private BetByMarketPlaceOrderRiskDetail riskDetail;

    @Column(value = "selection_id")
    @CassandraType(type = DataType.Name.BIGINT)
    private Long selectionId;

    @Column(value = "settled_date")
    @CassandraType(type = DataType.Name.TIMESTAMP)
    private Date settledDate;

    @Column(value = "side")
    @CassandraType(type = DataType.Name.TEXT)
    private Side side;

    @Column(value = "size")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal size;

    @Column(value = "size_cancelled")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal sizeCancelled;

    @Column(value = "size_lapsed")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal sizeLapsed;

    @Column(value = "size_matched")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal sizeMatched;

    @Column(value = "size_placed")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal sizePlaced;

    @Column(value = "size_remaining")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal sizeRemaining;

    @Column(value = "size_voided")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal sizeVoided;

    @Column(value = "sport_id")
    @CassandraType(type = DataType.Name.BIGINT)
    private Long sportId;

    @Column(value = "state")
    @CassandraType(type = DataType.Name.INT)
    private Integer state;

    @Column(value = "version")
    @CassandraType(type = DataType.Name.INT)
    private Integer version;

    public BetByMarketKey getKey() {
        return key;
    }

    public void setKey(BetByMarketKey key) {
        this.key = key;
    }

    public BigDecimal getAbsoluteExRate() {
        return absoluteExRate;
    }

    public void setAbsoluteExRate(BigDecimal absoluteExRate) {
        this.absoluteExRate = absoluteExRate;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getAvgPriceMatched() {
        return avgPriceMatched;
    }

    public void setAvgPriceMatched(BigDecimal avgPriceMatched) {
        this.avgPriceMatched = avgPriceMatched;
    }

    public Long getBetId() {
        return betId;
    }

    public void setBetId(Long betId) {
        this.betId = betId;
    }

    public Date getCancelledDate() {
        return cancelledDate;
    }

    public void setCancelledDate(Date cancelledDate) {
        this.cancelledDate = cancelledDate;
    }

    public BigDecimal getHandicap() {
        return handicap;
    }

    public void setHandicap(BigDecimal handicap) {
        this.handicap = handicap;
    }

    public Integer getMarketBettingType() {
        return marketBettingType;
    }

    public void setMarketBettingType(Integer marketBettingType) {
        this.marketBettingType = marketBettingType;
    }

    public Date getMatchedDate() {
        return matchedDate;
    }

    public void setMatchedDate(Date matchedDate) {
        this.matchedDate = matchedDate;
    }

    public Integer getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
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

    public String getPlacedIp() {
        return placedIp;
    }

    public void setPlacedIp(String placedIp) {
        this.placedIp = placedIp;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public Map<Long, BigDecimal> getRiskCeofficient() {
        return riskCeofficient;
    }

    public void setRiskCeofficient(Map<Long, BigDecimal> riskCeofficient) {
        this.riskCeofficient = riskCeofficient;
    }

    public BetByMarketPlaceOrderRiskDetail getRiskDetail() {
        return riskDetail;
    }

    public void setRiskDetail(BetByMarketPlaceOrderRiskDetail riskDetail) {
        this.riskDetail = riskDetail;
    }

    public Long getSelectionId() {
        return selectionId;
    }

    public void setSelectionId(Long selectionId) {
        this.selectionId = selectionId;
    }

    public Date getSettledDate() {
        return settledDate;
    }

    public void setSettledDate(Date settledDate) {
        this.settledDate = settledDate;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }

    public BigDecimal getSizeCancelled() {
        return sizeCancelled;
    }

    public void setSizeCancelled(BigDecimal sizeCancelled) {
        this.sizeCancelled = sizeCancelled;
    }

    public BigDecimal getSizeLapsed() {
        return sizeLapsed;
    }

    public void setSizeLapsed(BigDecimal sizeLapsed) {
        this.sizeLapsed = sizeLapsed;
    }

    public BigDecimal getSizeMatched() {
        return sizeMatched;
    }

    public void setSizeMatched(BigDecimal sizeMatched) {
        this.sizeMatched = sizeMatched;
    }

    public BigDecimal getSizePlaced() {
        return sizePlaced;
    }

    public void setSizePlaced(BigDecimal sizePlaced) {
        this.sizePlaced = sizePlaced;
    }

    public BigDecimal getSizeRemaining() {
        return sizeRemaining;
    }

    public void setSizeRemaining(BigDecimal sizeRemaining) {
        this.sizeRemaining = sizeRemaining;
    }

    public BigDecimal getSizeVoided() {
        return sizeVoided;
    }

    public void setSizeVoided(BigDecimal sizeVoided) {
        this.sizeVoided = sizeVoided;
    }

    public Long getSportId() {
        return sportId;
    }

    public void setSportId(Long sportId) {
        this.sportId = sportId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "BetByMarket{" +
                "key=" + key +
                ", absoluteExRate=" + absoluteExRate +
                ", accountId=" + accountId +
                ", avgPriceMatched=" + avgPriceMatched +
                ", betId=" + betId +
                ", cancelledDate=" + cancelledDate +
                ", handicap=" + handicap +
                ", marketBettingType=" + marketBettingType +
                ", matchedDate=" + matchedDate +
                ", partnerId=" + partnerId +
                ", persistenceType=" + persistenceType +
                ", placedDate=" + placedDate +
                ", placedIp='" + placedIp + '\'' +
                ", price=" + price +
                ", profit=" + profit +
                ", riskCeofficient=" + riskCeofficient +
                ", riskDetail=" + riskDetail +
                ", selectionId=" + selectionId +
                ", settledDate=" + settledDate +
                ", side=" + side +
                ", size=" + size +
                ", sizeCancelled=" + sizeCancelled +
                ", sizeLapsed=" + sizeLapsed +
                ", sizeMatched=" + sizeMatched +
                ", sizePlaced=" + sizePlaced +
                ", sizeRemaining=" + sizeRemaining +
                ", sizeVoided=" + sizeVoided +
                ", sportId=" + sportId +
                ", state=" + state +
                ", version=" + version +
                '}';
    }
}
