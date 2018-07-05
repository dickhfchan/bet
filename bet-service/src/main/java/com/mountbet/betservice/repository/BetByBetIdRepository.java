package com.mountbet.betservice.repository;

import com.mountbet.betservice.entity.BetByBetId;
import com.mountbet.betservice.entity.key.BetByBetId.BetByBetIdKey;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface BetByBetIdRepository extends CassandraRepository<BetByBetId, BetByBetIdKey> {
    BetByBetId findByKeyMarketIdAndBetId(String marketId, Long betId);
}
