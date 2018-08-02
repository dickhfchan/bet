package com.mountbet.betservice.service;

import com.mountbet.betservice.constant.Side;
import com.mountbet.betservice.constant.State;
import com.mountbet.betservice.constant.Status;
import com.mountbet.betservice.dto.CancelOrder.CancelExecutionReport;
import com.mountbet.betservice.dto.CancelOrder.CancelInstruction;
import com.mountbet.betservice.dto.CancelOrder.CancelInstructionReport;
import com.mountbet.betservice.dto.NavigationDetail;
import com.mountbet.betservice.dto.PlaceOrder.PlaceExecutionReport;
import com.mountbet.betservice.dto.PlaceOrder.PlaceInstruction;
import com.mountbet.betservice.dto.PlaceOrder.PlaceInstructionReport;
import com.mountbet.betservice.dto.ReplaceOrder.ReplaceExecutionReport;
import com.mountbet.betservice.dto.ReplaceOrder.ReplaceInstructionReport;
import com.mountbet.betservice.dto.UpdateOrder.UpdateExecutionReport;
import com.mountbet.betservice.dto.UpdateOrder.UpdateInstruction;
import com.mountbet.betservice.dto.UpdateOrder.UpdateInstructionReport;
import com.mountbet.betservice.entity.BetByMarket;
import com.mountbet.betservice.entity.key.BetByMarketKey;
import com.mountbet.betservice.repository.BetByMarketRepository;
import com.mountbet.betservice.rest_template.NavigationRestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BetByMarketService {
    private static final Logger LOG = LoggerFactory.getLogger(BetByMarketService.class);

    @Autowired
    private BetByMarketRepository betByMarketRepository;

    @Autowired
    private NavigationRestTemplate navigationRestTemplate;

    public void placeBet(PlaceExecutionReport placeExecutionReport) {
        String marketId = placeExecutionReport.getMarketId();
        List<PlaceInstructionReport> placeInstructionReportList = placeExecutionReport.getInstructionReports();
        for (PlaceInstructionReport placeInstructionReport : placeInstructionReportList) {
            doPlaceBet(placeInstructionReport, marketId);
        }
    }

    public void doPlaceBet(PlaceInstructionReport placeInstructionReport, String marketId) {
        if (placeInstructionReport.getStatus().equals("SUCCESS")) {
            PlaceInstruction placeInstruction = placeInstructionReport.getInstruction();
            NavigationDetail navigationDetail = navigationRestTemplate.getMarketDetails(marketId);
            BetByMarket betByMarket = new BetByMarket();
            betByMarket.setKey(buildBetByMarketKey(marketId, navigationDetail.getEventTypeId(), navigationDetail.getEventId(), placeInstruction.getSelectionId(), placeInstructionReport.getBetId(), 100l, State.UNMATCHED, placeInstruction.getSide(), Status.CURRENT, placeInstructionReport.getPlacedDate()));
            betByMarket.setHandicap(placeInstructionReport.getInstruction().getHandicap());
            betByMarket.setSize(placeInstructionReport.getInstruction().getLimitOrder().getSize());
            betByMarket.setPrice(placeInstructionReport.getInstruction().getLimitOrder().getPrice());
            betByMarket.setPersistenceType(placeInstructionReport.getInstruction().getLimitOrder().getPersistenceType());
            betByMarket.setSizeMatched(new BigDecimal(placeInstructionReport.getSizeMatched(), MathContext.DECIMAL64));
            betByMarket.setSizeRemaining(placeInstructionReport.getInstruction().getLimitOrder().getSize().subtract(new BigDecimal(placeInstructionReport.getSizeMatched())));
            betByMarket.setSizePlaced(betByMarket.getSize());
            betByMarketRepository.saveBet(betByMarket);
        } else {
            LOG.error("Status failed in doPlaceBet: " + placeInstructionReport.getErrorCode());
        }
    }

    public void cancelBet(CancelExecutionReport cancelExecutionReport) {
        List<CancelInstructionReport> cancelInstructionReportList = cancelExecutionReport.getInstructionReports();
        for (CancelInstructionReport cancelInstructionReport : cancelInstructionReportList) {
            doCancelBet(cancelInstructionReport);
        }
    }

    public void doCancelBet(CancelInstructionReport cancelInstructionReport) {
        if (cancelInstructionReport.getStatus().equals("SUCCESS")) {
            CancelInstruction cancelInstruction = cancelInstructionReport.getInstruction();
            BetByMarket betByMarket = betByMarketRepository.findBetByBetId(cancelInstruction.getBetId());
            BigDecimal newSize = betByMarket.getSize().subtract(new BigDecimal(cancelInstructionReport.getSizeCancelled()));
            betByMarket.setSize(newSize);
            betByMarketRepository.saveBet(betByMarket);
        } else {
            LOG.error("Status failed in doCancelBet: " + cancelInstructionReport.getErrorCode());
        }
    }

    public void replaceBet(ReplaceExecutionReport replaceExecutionReport) {
        String marketId = replaceExecutionReport.getMarketId();
        List<ReplaceInstructionReport> replaceInstructionReportList = replaceExecutionReport.getInstructionReports();
        for (ReplaceInstructionReport replaceInstructionReport : replaceInstructionReportList) {
            CancelInstructionReport cancelInstructionReport = replaceInstructionReport.getCancelInstructionReport();
            PlaceInstructionReport placeInstructionReport = replaceInstructionReport.getPlaceInstructionReport();
            doCancelBet(cancelInstructionReport);
            doPlaceBet(placeInstructionReport, marketId);
        }
    }

    public void updateBet(UpdateExecutionReport updateExecutionReport) {
        List<UpdateInstructionReport> updateInstructionReportList = updateExecutionReport.getInstructionReports();
        for (UpdateInstructionReport updateInstructionReport : updateInstructionReportList) {
            if (updateExecutionReport.getStatus().equals("SUCCESS")) {
                UpdateInstruction updateInstruction = updateInstructionReport.getInstruction();
                BetByMarket betByMarket = betByMarketRepository.findBetByBetId(updateInstruction.getBetId());
                betByMarket.setPersistenceType(updateInstruction.getNewPersistenceType());
                betByMarketRepository.saveBet(betByMarket);
            } else {
                LOG.error("Status failed in updateBet: " + updateInstructionReport.getErrorCode());
            }
        }
    }

    private BetByMarketKey buildBetByMarketKey(String marketId, Long eventTypeId, Long eventId, Long selectionId, Long betId, Long accountId, State state, Side side, Status status, Date placedDate) {
        BetByMarketKey key = new BetByMarketKey();
        key.setMarketId(marketId);
        key.setEventTypeId(eventTypeId);
        key.setEventId(eventId);
        key.setSelectionId(selectionId);
        key.setBetId(betId);
        key.setAccountId(accountId);
        key.setState(state);
        key.setSide(side);
        key.setStatus(status);
        key.setPlacedDate(placedDate);
        return key;
    }
}
