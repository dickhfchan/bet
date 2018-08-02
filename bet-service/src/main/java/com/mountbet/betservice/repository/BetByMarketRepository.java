package com.mountbet.betservice.repository;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.mountbet.betservice.entity.BetByMarket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

@Repository
public class BetByMarketRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(BetByMarketRepository.class);

    @Autowired
    private CassandraOperations cassandraOperations;

    public void saveBet(BetByMarket betByMarket) {
        cassandraOperations.update(betByMarket);
    }

    public void deleteBet(BetByMarket betByMarket) {
        cassandraOperations.delete(betByMarket);
    }

    public BetByMarket findBetByBetId(Long betId) {
        Select.Where select = QueryBuilder
                .select()
                .from("bet_by_bet_id")
                .where(QueryBuilder.eq("bet_id", betId));
        BetByMarket betByMarket = cassandraOperations.selectOne(select, BetByMarket.class);
        return betByMarket;
    }
}
