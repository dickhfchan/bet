package com.mountbet.betservice.entity.udt.BetByMarket;

import com.datastax.driver.core.DataType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.math.BigDecimal;

/**
 * @author AnsonChan
 * @since 28/6/2018
 */
@UserDefinedType("place_order_risk_detail")
public class BetByMarketPlaceOrderRiskDetail {
    @Column(value = "account_id")
    @CassandraType(type = DataType.Name.BIGINT)
    private Long accountId;

    @Column(value = "value")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal value;

    @Column(value = "type")
    @CassandraType(type = DataType.Name.INT)
    private Integer type;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "BetByMarketPlaceOrderRiskDetail{" +
                "accountId=" + accountId +
                ", value=" + value +
                ", type=" + type +
                '}';
    }
}
