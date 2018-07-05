package com.mountbet.betservice.service;

import com.datastax.driver.core.utils.UUIDs;
import com.mountbet.betservice.dto.CancelOrder.CancelInstruction;
import com.mountbet.betservice.dto.CancelOrder.CancelInstructionReport;
import com.mountbet.betservice.dto.PlaceOrder.PlaceExecutionReport;
import com.mountbet.betservice.dto.PlaceOrder.PlaceInstructionReport;
import com.mountbet.betservice.entity.BetByBetId;
import com.mountbet.betservice.entity.BetByMarket;
import com.mountbet.betservice.entity.key.BetByMarket.BetByMarketKey;
import com.mountbet.betservice.repository.BetByBetIdRepository;
import com.mountbet.betservice.repository.BetByMarketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    private BetByMarketRepository betByMarketRepository;

    @Autowired
    private BetByBetIdRepository betByBetIdRepository;

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
        betByMarket.setKey(betByMarketKey);
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

    public void cancelBet(String marketId, CancelInstructionReport cancelInstructionReport) {
        BigDecimal newSize;
        CancelInstruction cancelInstruction = cancelInstructionReport.getInstruction();
        Long oldBetId = cancelInstruction.getBetId();
        BetByBetId betByBetId = betByBetIdRepository.findByKeyMarketIdAndBetId(marketId, oldBetId);
        if (cancelInstruction.getSizeReduction() == null) {
            newSize = betByBetId.getSize().subtract(new BigDecimal(cancelInstructionReport.getSizeCancelled()));
        } else {
            newSize = betByBetId.getSize().subtract(cancelInstruction.getSizeReduction());
        }
        LOG.debug(newSize.toString());
        UUID id = betByBetId.getKey().getId();
        BetByMarket betByMarket = betByMarketRepository.findByKeyMarketIdAndKeyId(marketId, id);
        LOG.debug(betByMarket.toString());
        betByMarket.setSize(newSize);
        betByMarketRepository.save(betByMarket);
    }

    public BetByMarket checkExist(String marketId, String betId) {
        BetByBetId betByBetId = betByBetIdRepository.findByKeyMarketIdAndBetId(marketId, Long.parseLong(betId));
        if (betByBetId == null) {
            return null;
        } else {
            UUID id = betByBetId.getKey().getId();
            BetByMarket betByMarket = betByMarketRepository.findByKeyMarketIdAndKeyId(marketId, id);
            return betByMarket;
        }
    }

    private BetByMarketKey buildBetByMarketKey(String marketId) {
        BetByMarketKey key = new BetByMarketKey();
        key.setMarketId(marketId);
        key.setId(UUIDs.timeBased());
        return key;
    }

}
