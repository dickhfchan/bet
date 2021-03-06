package com.mountbet.betservice.repository;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.mountbet.betservice.constant.OrderProjection;
import com.mountbet.betservice.dto.TimeRange;
import com.mountbet.betservice.entity.BetByMarket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.*;

import static com.mountbet.betservice.constant.OrderProjection.EXECUTABLE;
import static com.mountbet.betservice.constant.OrderProjection.EXECUTION_COMPLETE;

@Repository
@Validated
public class BetByMarketRepository {
    private static final Logger LOG = LoggerFactory.getLogger(BetByMarketRepository.class);

    @Autowired
    private CassandraOperations cassandraOperations;

    public void saveBet(BetByMarket betByMarket) {
        cassandraOperations.update(betByMarket);
    }

    public void deleteBet(BetByMarket betByMarket) {
        cassandraOperations.delete(betByMarket);
    }

    public BetByMarket getBetById(@NotNull Long betId) {
        Select.Where select = QueryBuilder
                .select()
                .from("bet_by_bet_id")
                .where(QueryBuilder.eq("bet_id", betId));
        BetByMarket betByMarket = cassandraOperations.selectOne(select, BetByMarket.class);
        return betByMarket;
    }

    public List<BetByMarket> getBetsByIds(@NotNull @NotEmpty Set<Long> betIds) {
        Select.Where select = QueryBuilder
                .select()
                .from("bet_by_bet_id")
                .where(QueryBuilder.in("bet_id", betIds));
        List<BetByMarket> resultList = cassandraOperations.select(select, BetByMarket.class);
        return resultList;
    }


    //Below method will be called by account-service

    public List<BetByMarket> getCurrentBetByState(@NotNull Long accountId, TimeRange timeRange, OrderProjection orderProjection) {
        Set<String> state = getState(orderProjection);
        Select.Where selectWhere = QueryBuilder.select().from("bet_by_state_aid")
                .where(QueryBuilder.in("state", state))
                .and(QueryBuilder.eq("account_id", accountId))
                .and(QueryBuilder.eq("status", "CURRENT"));
        selectWhere = checkTimeRange(selectWhere, timeRange, "placed_date");
        LOG.debug("getCurrentBetByState selectWhere: " + selectWhere);
        List<BetByMarket> resultList = cassandraOperations.select(selectWhere, BetByMarket.class);
        return resultList;
    }

    public List<BetByMarket> getCurrentBetByMarketIdsAndState(Set<String> marketIdsSet, @NotNull Long accountId, TimeRange timeRange, OrderProjection orderProjection) {
        Set<String> state = getState(orderProjection);
        Select.Where selectWhere = QueryBuilder.select().from("bet_by_mid_state_aid")
                .where(QueryBuilder.in("market_id", marketIdsSet))
                .and(QueryBuilder.in("state", state))
                .and(QueryBuilder.eq("account_id", accountId))
                .and(QueryBuilder.eq("status", "CURRENT"));
        selectWhere = checkTimeRange(selectWhere, timeRange, "placed_date");
        LOG.debug("getCurrentBetByMarketIdsAndState selectWhere: " + selectWhere);
        List<BetByMarket> resultList = cassandraOperations.select(selectWhere, BetByMarket.class);
        return resultList;
    }

    public List<Long> getPastBetId(String selectColumn, Set<String> state, @NotNull Long accountId, TimeRange timeRange) {
        Select.Where selectWhere = QueryBuilder.select(selectColumn).from("bet_by_state")
                .where(QueryBuilder.in("state", state))
                .and(QueryBuilder.eq("account_id", accountId))
                .and(QueryBuilder.eq("status", "PAST"));
        selectWhere = checkTimeRange(selectWhere, timeRange, "settled_date");
        LOG.debug("getPastBet selectWhere: " + selectWhere);
        List<Long> resultList = cassandraOperations.select(selectWhere, Long.class);
        return resultList;
    }

    public List<Long> getPastBetIdByEventTypeIds(String selectColumn, Set<String> state, Set<String> eventTypeIdsSet, @NotNull Long accountId, TimeRange timeRange) {
        Select.Where selectWhere = QueryBuilder.select(selectColumn).from("bet_by_state_etid")
                .where(QueryBuilder.in("state", state))
                .and(QueryBuilder.in("event_type_id", eventTypeIdsSet))
                .and(QueryBuilder.eq("account_id", accountId))
                .and(QueryBuilder.eq("status", "PAST"));
        selectWhere = checkTimeRange(selectWhere, timeRange, "settled_date");
        LOG.debug("getPastBetByEventTypeIds selectWhere: " + selectWhere);
        List<Long> resultList = cassandraOperations.select(selectWhere, Long.class);
        return resultList;
    }

    public List<Long> getPastBetIdByEventIds(String selectColumn, Set<String> state, Set<String> eventIdsSet, @NotNull Long accountId, TimeRange timeRange) {
        Select.Where selectWhere = QueryBuilder.select(selectColumn).from("bet_by_state_eid")
                .where(QueryBuilder.in("state", state))
                .and(QueryBuilder.in("event_id", eventIdsSet))
                .and(QueryBuilder.eq("account_id", accountId))
                .and(QueryBuilder.eq("status", "PAST"));
        selectWhere = checkTimeRange(selectWhere, timeRange, "settled_date");
        LOG.debug("getPastBetByEventIds selectWhere: " + selectWhere);
        List<Long> resultList = cassandraOperations.select(selectWhere, Long.class);
        return resultList;
    }

    public List<Long> getPastBetIdByMarketIds(String selectColumn, Set<String> state, Set<String> marketIdsSet, @NotNull Long accountId, TimeRange timeRange) {
        Select.Where selectWhere = QueryBuilder.select(selectColumn).from("bet_by_state_mid")
                .where(QueryBuilder.in("state", state))
                .and(QueryBuilder.in("market_id", marketIdsSet))
                .and(QueryBuilder.eq("account_id", accountId))
                .and(QueryBuilder.eq("status", "PAST"));
        selectWhere = checkTimeRange(selectWhere, timeRange, "settled_date");
        LOG.debug("getPastBetByMarketIds selectWhere: " + selectWhere);
        List<Long> resultList = cassandraOperations.select(selectWhere, Long.class);
        return resultList;
    }

    public List<Long> getPastBetIdByBetIds(String selectColumn, Set<String> state, Set<String> betIdsSet, @NotNull Long accountId, TimeRange timeRange) {
        Select.Where selectWhere = QueryBuilder.select(selectColumn).from("bet_by_state_bid")
                .where(QueryBuilder.in("state", state))
                .and(QueryBuilder.in("bet_id", betIdsSet))
                .and(QueryBuilder.eq("account_id", accountId))
                .and(QueryBuilder.eq("status", "PAST"));
        selectWhere = checkTimeRange(selectWhere, timeRange, "settled_date");
        LOG.debug("getPastBetByBetIds selectWhere: " + selectWhere);
        List<Long> resultList = cassandraOperations.select(selectWhere, Long.class);
        return resultList;
    }

    public List<BetByMarket> getBetByBetId(List<Long> betIdsList) {
        Set<Long> betIdsSet = new HashSet<Long>(betIdsList);
        Select select = QueryBuilder.select().from("bet_by_bet_id")
                .where(QueryBuilder.in("bet_id", betIdsSet))
                .groupBy("bet_id");
        List<BetByMarket> resultList = cassandraOperations.select(select, BetByMarket.class);
        return resultList;
    }

    public List<BetByMarket> getBetBySelectionId(List<Long> selectionIdsList) {
        Set<Long> selectionIdsSet = new HashSet<Long>(selectionIdsList);
        Select select = QueryBuilder.select(
                "event_type_id",
                "event_id",
                "market_id",
                "selection_id",
                "handicap",
                "side"
        ).from("bet_by_sid")
                .where(QueryBuilder.in("selection_id", selectionIdsSet))
                .groupBy("selection_id");
        LOG.debug("getBetBySelectionId select:" + select.toString());
        List<BetByMarket> resultList = cassandraOperations.select(select, BetByMarket.class);
        List<BetByMarket> finalList = new ArrayList<>();
        for (BetByMarket betByMarket : resultList) {
            Select.Where selectMaxSettledDate = QueryBuilder.select(QueryBuilder.max("settled_date")).from("bet_by_sid")
                    .where(QueryBuilder.eq("selection_id", betByMarket.getKey().getSelectionId()));
            Select.Where selectCountBetId = QueryBuilder.select(QueryBuilder.count("bet_id")).from("bet_by_sid")
                    .where(QueryBuilder.eq("selection_id", betByMarket.getKey().getSelectionId()));
            Select.Where selectMaxSizeCancelled = QueryBuilder.select(QueryBuilder.sum("size_cancelled")).from("bet_by_sid")
                    .where(QueryBuilder.eq("selection_id", betByMarket.getKey().getSelectionId()));
            Select.Where selectMaxSizeVoided = QueryBuilder.select(QueryBuilder.sum("size_voided")).from("bet_by_sid")
                    .where(QueryBuilder.eq("selection_id", betByMarket.getKey().getSelectionId()));
            Date maxSettledDate = cassandraOperations.selectOne(selectMaxSettledDate, Date.class);
            Integer countBetId = cassandraOperations.selectOne(selectCountBetId, Integer.class);
            BigDecimal maxSizeCancelled = cassandraOperations.selectOne(selectMaxSizeCancelled, BigDecimal.class);
            BigDecimal maxSizeVoided = cassandraOperations.selectOne(selectMaxSizeVoided, BigDecimal.class);
            betByMarket.setSettledDate(maxSettledDate);
            betByMarket.setBetCount(countBetId);
            betByMarket.setSizeCancelled(maxSizeCancelled);
            betByMarket.setSizeVoided(maxSizeVoided);

            finalList.add(betByMarket);
        }

        return finalList;
    }

    public List<BetByMarket> getBetByMarketId(List<Long> marketIdsList) {
        Set<Long> marketIdsSet = new HashSet<Long>(marketIdsList);
        Select select = QueryBuilder.select(
                "event_type_id",
                "event_id",
                "market_id"
        ).from("bet_by_mid_aid")
                .where(QueryBuilder.in("market_id", marketIdsSet))
                .groupBy("market_id");
        LOG.debug("getBetByMarketId select:" + select.toString());
        List<BetByMarket> resultList = cassandraOperations.select(select, BetByMarket.class);
        List<BetByMarket> finalList = new ArrayList<>();
        for (BetByMarket betByMarket : resultList) {
            Select.Where selectMaxSettledDate = QueryBuilder.select(QueryBuilder.max("settled_date")).from("bet_by_mid_aid")
                    .where(QueryBuilder.eq("market_id", betByMarket.getKey().getMarketId()));
            Select.Where selectCountBetId = QueryBuilder.select(QueryBuilder.count("bet_id")).from("bet_by_mid_aid")
                    .where(QueryBuilder.eq("market_id", betByMarket.getKey().getMarketId()));
            Select.Where selectMaxSizeVoided = QueryBuilder.select(QueryBuilder.sum("size_voided")).from("bet_by_mid_aid")
                    .where(QueryBuilder.eq("market_id", betByMarket.getKey().getMarketId()));
            Date maxSettledDate = cassandraOperations.selectOne(selectMaxSettledDate, Date.class);
            Integer countBetId = cassandraOperations.selectOne(selectCountBetId, Integer.class);
            BigDecimal maxSizeVoided = cassandraOperations.selectOne(selectMaxSizeVoided, BigDecimal.class);
            betByMarket.setSettledDate(maxSettledDate);
            betByMarket.setBetCount(countBetId);
            betByMarket.setSizeVoided(maxSizeVoided);

            finalList.add(betByMarket);
        }

        return finalList;
    }

    public List<BetByMarket> getBetByEventId(List<Long> eventIdsList) {
        Set<Long> eventIdsSet = new HashSet<Long>(eventIdsList);
        Select select = QueryBuilder.select(
                "event_type_id",
                "event_id"
        ).from("bet_by_eid")
                .where(QueryBuilder.in("event_id", eventIdsSet))
                .groupBy("event_id");
        LOG.debug("getBetByEventId select:" + select.toString());
        List<BetByMarket> resultList = cassandraOperations.select(select, BetByMarket.class);
        List<BetByMarket> finalList = new ArrayList<>();
        for (BetByMarket betByMarket : resultList) {
            Select.Where selectMaxSettledDate = QueryBuilder.select(QueryBuilder.max("settled_date")).from("bet_by_eid")
                    .where(QueryBuilder.eq("event_id", betByMarket.getKey().getEventId()));
            Select.Where selectCountBetId = QueryBuilder.select(QueryBuilder.count("bet_id")).from("bet_by_eid")
                    .where(QueryBuilder.eq("event_id", betByMarket.getKey().getEventId()));
            Date maxSettledDate = cassandraOperations.selectOne(selectMaxSettledDate, Date.class);
            Integer countBetId = cassandraOperations.selectOne(selectCountBetId, Integer.class);
            betByMarket.setSettledDate(maxSettledDate);
            betByMarket.setBetCount(countBetId);

            finalList.add(betByMarket);
        }

        return finalList;
    }


    public List<BetByMarket> getBetByEventTypeId(List<Long> eventTypeIdsList) {
        Set<Long> eventTypeIdsSet = new HashSet<Long>(eventTypeIdsList);
        Select select = QueryBuilder.select(
                "event_type_id"
        ).from("bet_by_etid")
                .where(QueryBuilder.in("event_type_id", eventTypeIdsSet))
                .groupBy("event_type_id");
        LOG.debug("getBetByEventTypeId select:" + select.toString());
        List<BetByMarket> resultList = cassandraOperations.select(select, BetByMarket.class);
        List<BetByMarket> finalList = new ArrayList<>();
        for (BetByMarket betByMarket : resultList) {
            Select.Where selectMaxSettledDate = QueryBuilder.select(QueryBuilder.max("settled_date")).from("bet_by_etid")
                    .where(QueryBuilder.eq("event_type_id", betByMarket.getKey().getEventTypeId()));
            Select.Where selectCountBetId = QueryBuilder.select(QueryBuilder.count("bet_id")).from("bet_by_etid")
                    .where(QueryBuilder.eq("event_type_id", betByMarket.getKey().getEventTypeId()));
            Date maxSettledDate = cassandraOperations.selectOne(selectMaxSettledDate, Date.class);
            Integer countBetId = cassandraOperations.selectOne(selectCountBetId, Integer.class);
            betByMarket.setSettledDate(maxSettledDate);
            betByMarket.setBetCount(countBetId);

            finalList.add(betByMarket);
        }

        return finalList;
    }

    public double getSumOfSizeMatchedByMarketId(String marketId) {
        Select.Where selectWhere = QueryBuilder.select(QueryBuilder.sum("size_matched"))
                .from("bet_by_market")
                .where(QueryBuilder.eq("market_id", marketId));
        double result = cassandraOperations.selectOne(selectWhere, Double.class);
        return result;
    }

    private Set<String> getState(OrderProjection orderProjection) {
        Set<String> state = new HashSet<>();
        if (orderProjection == EXECUTABLE) {
            state.add("UNMATCHED");
        } else if (orderProjection == EXECUTION_COMPLETE) {
            state.add("MATCHED");
        } else {
            state.add("MATCHED");
            state.add("UNMATCHED");
        }
        return state;
    }

    /*Statement for the time range that the JSON specified that will append to the original statement.
     *If the JSON does not have any time range, this statement will not append to query statement.
     */
    private Select.Where checkTimeRange(Select.Where selectWhere, TimeRange timeRange, String name) {
        if (timeRange != null) {
            if (timeRange.getFrom() != null) {
                selectWhere = selectWhere.and(QueryBuilder.gte(name, timeRange.getFrom()));
            }
            if (timeRange.getTo() != null) {
                selectWhere = selectWhere.and(QueryBuilder.lte(name, timeRange.getTo()));
            }
            return selectWhere;
        } else {
            return selectWhere;
        }
    }

    public Set<Long> getBetIdsByAccountId(@NotNull Long accountId) {
        Select.Where selectWhere = QueryBuilder.select("bet_id")
                .from("bet_by_aid")
                .where(QueryBuilder.eq("account_id", accountId));
        List<Long> betIds = cassandraOperations.select(selectWhere, Long.class);
        return new HashSet<>(betIds);
    }

    public Set<Long> getBetIdsByAccountIds(@NotNull @NotEmpty Set<Long> accountIds) {
        Select.Where selectWhere = QueryBuilder.select("bet_id")
                .from("bet_by_aid")
                .where(QueryBuilder.in("account_id", accountIds));
        List<Long> betIds = cassandraOperations.select(selectWhere, Long.class);
        return new HashSet<>(betIds);
    }
}
