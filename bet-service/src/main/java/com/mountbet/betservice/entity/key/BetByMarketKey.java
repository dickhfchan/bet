package com.mountbet.betservice.entity.key;

import com.datastax.driver.core.DataType;
import com.mountbet.betservice.constant.Side;
import com.mountbet.betservice.constant.State;
import com.mountbet.betservice.constant.Status;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import javax.validation.constraints.NotNull;
import java.util.Date;

@PrimaryKeyClass
public class BetByMarketKey {
    @NotNull
    @PrimaryKeyColumn(name = "market_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    @CassandraType(type = DataType.Name.TEXT)
    private String marketId;

    @NotNull
    @PrimaryKeyColumn(name = "event_type_id", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    @CassandraType(type = DataType.Name.BIGINT)
    private Long eventTypeId;

    @NotNull
    @PrimaryKeyColumn(name = "event_id", ordinal = 2, type = PrimaryKeyType.CLUSTERED)
    @CassandraType(type = DataType.Name.BIGINT)
    private Long eventId;

    @NotNull
    @PrimaryKeyColumn(name = "selection_id", ordinal = 3, type = PrimaryKeyType.CLUSTERED)
    @CassandraType(type = DataType.Name.BIGINT)
    private Long selectionId;

    @NotNull
    @PrimaryKeyColumn(name = "bet_id", ordinal = 4, type = PrimaryKeyType.CLUSTERED)
    @CassandraType(type = DataType.Name.BIGINT)
    private Long betId;

    @NotNull
    @PrimaryKeyColumn(name = "account_id", ordinal = 5, type = PrimaryKeyType.CLUSTERED)
    @CassandraType(type = DataType.Name.BIGINT)
    private Long accountId;

    @NotNull
    @PrimaryKeyColumn(name = "state", ordinal = 6, type = PrimaryKeyType.CLUSTERED)
    @CassandraType(type = DataType.Name.TEXT)
    private State state;

    @NotNull
    @PrimaryKeyColumn(name = "side", ordinal = 7, type = PrimaryKeyType.CLUSTERED)
    @CassandraType(type = DataType.Name.TEXT)
    private Side side;

    @NotNull
    @PrimaryKeyColumn(name = "status", ordinal = 8, type = PrimaryKeyType.CLUSTERED)
    @CassandraType(type = DataType.Name.TEXT)
    private Status status;

    @NotNull
    @PrimaryKeyColumn(name = "placed_date", ordinal = 9, type = PrimaryKeyType.CLUSTERED)
    @CassandraType(type = DataType.Name.TIMESTAMP)
    private Date placedDate;

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

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

    public Long getSelectionId() {
        return selectionId;
    }

    public void setSelectionId(Long selectionId) {
        this.selectionId = selectionId;
    }

    public Long getBetId() {
        return betId;
    }

    public void setBetId(Long betId) {
        this.betId = betId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getPlacedDate() {
        return placedDate;
    }

    public void setPlacedDate(Date placedDate) {
        this.placedDate = placedDate;
    }

    @Override
    public String toString() {
        return "BetByMarketKey{" +
                "marketId='" + marketId + '\'' +
                ", eventTypeId=" + eventTypeId +
                ", eventId=" + eventId +
                ", selectionId=" + selectionId +
                ", betId=" + betId +
                ", accountId=" + accountId +
                ", state=" + state +
                ", side=" + side +
                ", status=" + status +
                ", placedDate=" + placedDate +
                '}';
    }
}