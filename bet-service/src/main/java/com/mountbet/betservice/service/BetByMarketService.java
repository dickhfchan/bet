package com.mountbet.betservice.service;

import com.mountbet.betservice.constant.OrderProjection;
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
import com.mountbet.betservice.dto.TimeRange;
import com.mountbet.betservice.dto.UpdateOrder.UpdateExecutionReport;
import com.mountbet.betservice.dto.UpdateOrder.UpdateInstruction;
import com.mountbet.betservice.dto.UpdateOrder.UpdateInstructionReport;
import com.mountbet.betservice.entity.BetByMarket;
import com.mountbet.betservice.entity.key.BetByMarketKey;
import com.mountbet.betservice.repository.BetByMarketRepository;
import com.mountbet.betservice.client.NavigationClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class BetByMarketService {
    private static final Logger LOG = LoggerFactory.getLogger(BetByMarketService.class);

    @Autowired
    private BetByMarketRepository betByMarketRepository;

    @Autowired
    private NavigationClient navigationClient;

    public List<BetByMarket> getCurrentBetByState(@NotNull Long accountId, TimeRange timeRange, OrderProjection orderProjection){
        return betByMarketRepository.getCurrentBetByState(
                accountId,
                timeRange,
                orderProjection
        );
    }

    public List<BetByMarket> getCurrentBetByMarketIdsAndState(Set<String> marketIdsSet, @NotNull Long accountId, TimeRange timeRange, OrderProjection orderProjection){
        return betByMarketRepository.getCurrentBetByMarketIdsAndState(
                marketIdsSet,
                accountId,
                timeRange,
                orderProjection
        );
    }

    public List<Long> getPastBetId(String selectColumns, Set<String> state, @NotNull Long accountId,  TimeRange timeRange){
        return betByMarketRepository.getPastBetId(
                selectColumns,
                state,
                accountId,
                timeRange
        );
    }

    public List<Long> getPastBetIdByEventTypeIds(String selectColumns, Set<String> state, Set<String> eventTypeIdsSet, @NotNull Long accountId, TimeRange timeRange){
        return betByMarketRepository.getPastBetIdByEventTypeIds(
                selectColumns,
                state,
                eventTypeIdsSet,
                accountId,
                timeRange
        );
    }

    public List<Long> getPastBetIdByEventIds(String selectColumns, Set<String> state, Set<String> eventIdsSet, @NotNull Long accountId,  TimeRange timeRange){
        return betByMarketRepository.getPastBetIdByEventIds(
                selectColumns,
                state,
                eventIdsSet,
                accountId,
                timeRange
        );
    }

    public List<Long> getPastBetIdByMarketIds(String selectColumns, Set<String> state, Set<String> marketIdsSet, @NotNull Long accountId,  TimeRange timeRange){
        return betByMarketRepository.getPastBetIdByMarketIds(
                selectColumns,
                state,
                marketIdsSet,
                accountId,
                timeRange
        );
    }

    public List<Long> getPastBetIdByBetIds(String selectColumns, Set<String> state, Set<String> betIdsSet, @NotNull Long accountId,  TimeRange timeRange){
        return betByMarketRepository.getPastBetIdByBetIds(
                selectColumns,
                state,
                betIdsSet,
                accountId,
                timeRange
        );
    }

    public List<BetByMarket> getPastBetByBetId(List<Long> betIdsList){
        return betByMarketRepository.getPastBetByBetId(betIdsList);
    }

    public List<BetByMarket> getPastBetBySelectionId(List<Long> selectionIdsList){
        return betByMarketRepository.getPastBetBySelectionId(selectionIdsList);
    }

    public List<BetByMarket> getPastBetByMarketId(List<Long> marketIdsList){
        return betByMarketRepository.getPastBetByMarketId(marketIdsList);
    }

    public List<BetByMarket> getPastBetByEventId(List<Long> eventIdsList){
        return betByMarketRepository.getPastBetByEventId(eventIdsList);
    }

    public List<BetByMarket> getPastBetByEventTypeId(List<Long> eventTypeIdsList){
        return betByMarketRepository.getPastBetByEventTypeId(eventTypeIdsList);
    }

    public double getSumOfSizeMatchedByMarketId(String marketId){
        return betByMarketRepository.getSumOfSizeMatchedByMarketId(marketId);
    }

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
            NavigationDetail navigationDetail = navigationClient.getMarketDetails(marketId);
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
