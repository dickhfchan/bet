package com.mountbet.betservice.repository;

import com.mountbet.betservice.entity.BetByMarket;
import com.mountbet.betservice.entity.key.BetByMarket.BetByMarketKey;
import org.springframework.data.cassandra.repository.CassandraRepository;

/**
 * @author AnsonChan
 * @since 4/7/2018
 */
public interface BetByMarketRepository extends CassandraRepository<BetByMarket, BetByMarketKey> {
}