package com.mountbet.betservice.service;

import com.mountbet.betservice.dto.CancelOrder.CancelExecutionReport;
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
        List<PlaceInstructionReport> placeInstructionReportList = placeExecutionReport.getInstructionReports();
        for (PlaceInstructionReport placeInstructionReport : placeInstructionReportList) {
            if (placeInstructionReport.getStatus().equals("SUCCESS")) {
                BetByMarket betByMarket = new BetByMarket();

                betByMarket.setKey(buildBetByMarketKey(placeExecutionReport.getMarketId()));
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
            } else {
                LOG.error("Status failed: " + placeInstructionReport.getErrorCode());
            }
        }
    }

    public void cancelBet(CancelExecutionReport cancelExecutionReport) {
        String marketId = cancelExecutionReport.getMarketId();
        List<CancelInstructionReport> cancelInstructionReportList = cancelExecutionReport.getInstructionReports();
        for (CancelInstructionReport cancelInstructionReport : cancelInstructionReportList) {
            if (cancelInstructionReport.getStatus().equals("SUCCESS")) {
                BigDecimal newSize;
                CancelInstruction cancelInstruction = cancelInstructionReport.getInstruction();
                Long oldBetId = cancelInstruction.getBetId();
                BetByBetId betByBetId = betByBetIdRepository.findByKeyMarketIdAndBetId(marketId, oldBetId);
                newSize = betByBetId.getSize().subtract(new BigDecimal(cancelInstructionReport.getSizeCancelled()));
                LOG.debug(newSize.toString());
                UUID id = betByBetId.getKey().getId();
                BetByMarket betByMarket = betByMarketRepository.findByKeyMarketIdAndKeyId(marketId, id);
                LOG.debug(betByMarket.toString());
                betByMarket.setSize(newSize);
                betByMarketRepository.save(betByMarket);
            } else {
                LOG.error("Status failed: " + cancelInstructionReport.getErrorCode());
            }
        }
    }


    private BetByMarketKey buildBetByMarketKey(String marketId) {
        BetByMarketKey key = new BetByMarketKey();
        key.setMarketId(marketId);
        key.setId(UUID.randomUUID());
        return key;
    }

}
