package com.mountbet.betservice.service;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.datastax.driver.core.utils.UUIDs;
import com.mountbet.betservice.dto.PlaceOrder.PlaceExecutionReport;
import com.mountbet.betservice.dto.PlaceOrder.PlaceInstructionReport;
import com.mountbet.betservice.entity.BetByMarket;
import com.mountbet.betservice.entity.key.BetByMarket.BetByMarketKey;
import com.mountbet.betservice.repository.BetByMarketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.UUID;

/**
 * @author AnsonChan
 * @since 4/7/2018
 */
@Service
@Transactional
public class BetByMarketService {
    private static final Logger LOG = LoggerFactory.getLogger(BetByMarketService.class);

    @Autowired
    private CassandraOperations cassandraTemplate;

    @Autowired
    private BetByMarketRepository betByMarketRepository;

    public void newBet(PlaceExecutionReport placeExecutionReport) {
        BetByMarket betByMarket = new BetByMarket();
        betByMarket.setKey(buildBetByMarketKey(placeExecutionReport.getMarketId()));
        List<PlaceInstructionReport> placeInstructionReportList = placeExecutionReport.getInstructionReports();
        for (PlaceInstructionReport placeInstructionReport : placeInstructionReportList) {
            betByMarket.setSelectionId(placeInstructionReport.getInstruction().getSelectionId());
            betByMarket.setHandicap(placeInstructionReport.getInstruction().getHandicap());
            betByMarket.setSide(placeInstructionReport.getInstruction().getSide());

            betByMarket.setSize(placeInstructionReport.getInstruction().getLimitOrder().getSize());
            betByMarket.setPrice(placeInstructionReport.getInstruction().getLimitOrder().getPrice());
            betByMarket.setPersistenceType(placeInstructionReport.getInstruction().getLimitOrder().getPersistenceType());

            betByMarket.setBetId(Long.parseLong(placeInstructionReport.getBetId()));
            betByMarket.setPlacedDate(placeInstructionReport.getPlacedDate());
            betByMarket.setAvgPriceMatched(new BigDecimal(placeInstructionReport.getAveragePriceMatched(), MathContext.DECIMAL64));
            betByMarket.setSizeMatched(new BigDecimal(placeInstructionReport.getSizeMatched(), MathContext.DECIMAL64));

            LOG.debug(betByMarket.toString());
            betByMarketRepository.insert(betByMarket);
        }
    }

    public void updateBet(PlaceExecutionReport placeExecutionReport, BetByMarketKey betByMarketKey) {
        BetByMarket betByMarket = new BetByMarket();
        String marketId = betByMarketKey.getMarketId();
        UUID id = betByMarketKey.getId();
        betByMarket.setKey(buildBetByMarketKey(marketId, id));
        List<PlaceInstructionReport> placeInstructionReportList = placeExecutionReport.getInstructionReports();
        for (PlaceInstructionReport placeInstructionReport : placeInstructionReportList) {
            betByMarket.setSelectionId(placeInstructionReport.getInstruction().getSelectionId());
            betByMarket.setHandicap(placeInstructionReport.getInstruction().getHandicap());
            betByMarket.setSide(placeInstructionReport.getInstruction().getSide());

            betByMarket.setSize(placeInstructionReport.getInstruction().getLimitOrder().getSize());
            betByMarket.setPrice(placeInstructionReport.getInstruction().getLimitOrder().getPrice());
            betByMarket.setPersistenceType(placeInstructionReport.getInstruction().getLimitOrder().getPersistenceType());

            betByMarket.setBetId(Long.parseLong(placeInstructionReport.getBetId()));
            betByMarket.setPlacedDate(placeInstructionReport.getPlacedDate());
            betByMarket.setAvgPriceMatched(new BigDecimal(placeInstructionReport.getAveragePriceMatched(), MathContext.DECIMAL64));
            betByMarket.setSizeMatched(new BigDecimal(placeInstructionReport.getSizeMatched(), MathContext.DECIMAL64));

            LOG.debug(betByMarket.toString());
            betByMarketRepository.save(betByMarket);
        }

    }

    public BetByMarket checkExist(String marketId) {
        Select.Where sw = QueryBuilder.select().from("bet_by_market")
                .where(QueryBuilder.eq("market_id", marketId));
        BetByMarket betByMarketCheckExist = cassandraTemplate.selectOne(sw, BetByMarket.class);
        return betByMarketCheckExist;
    }

    private BetByMarketKey buildBetByMarketKey(String marketId) {
        BetByMarketKey key = new BetByMarketKey();
        key.setMarketId(marketId);
        key.setId(UUIDs.timeBased());
        return key;
    }

    private BetByMarketKey buildBetByMarketKey(String marketId, UUID id) {
        BetByMarketKey key = new BetByMarketKey();
        key.setMarketId(marketId);
        key.setId(id);
        return key;
    }
}
