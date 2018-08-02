package com.mountbet.betservice.entity.udt;

import com.datastax.driver.core.DataType;
import com.mountbet.betservice.constant.AccountType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.math.BigDecimal;

@UserDefinedType("risk_detail")
public class RiskDetail {
    @Column(value = "account_id")
    @CassandraType(type = DataType.Name.BIGINT)
    private Long accountId;

    @Column(value = "value")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal value;

    @Column(value = "type")
    @CassandraType(type = DataType.Name.TEXT)
    private AccountType type;

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

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "RiskDetail{" +
                "accountId=" + accountId +
                ", value=" + value +
                ", type=" + type +
                '}';
    }
}