package com.mountbet.betservice.controller;

import com.mountbet.betservice.dto.*;
import com.mountbet.betservice.entity.BetByMarket;
import com.mountbet.betservice.service.BetByMarketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequestMapping(path = "/bet")
@RestController
public class BetController {
    private static final Logger LOG = LoggerFactory.getLogger(BetController.class);

    @Autowired
    private BetByMarketService betByMarketService;

    @PostMapping(path = "/getCurrentBetByState", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<BetByMarket> getCurrentBetByState(@RequestHeader HttpHeaders httpHeaders, @RequestBody GetCurrentBetByStateDTO getCurrentBetByStateDTO) {
        LOG.debug("/getCurrentBetByState");
        LOG.debug(getCurrentBetByStateDTO.toString());
        return betByMarketService.getCurrentBetByState(
                getCurrentBetByStateDTO.getAccountId(),
                getCurrentBetByStateDTO.getTimeRange(),
                getCurrentBetByStateDTO.getOrderProjection()
        );
    }

    @PostMapping(path = "/getCurrentBetByMarketIdsAndState", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<BetByMarket> getCurrentBetByMarketIdsAndState(@RequestHeader HttpHeaders httpHeaders, @RequestBody GetCurrentBetByMarketIdsAndStateDTO getCurrentBetByMarketIdsAndStateDTO) {
        LOG.debug("/getCurrentBetByState");
        LOG.debug(getCurrentBetByMarketIdsAndStateDTO.toString());
        return betByMarketService.getCurrentBetByMarketIdsAndState(
                getCurrentBetByMarketIdsAndStateDTO.getMarketIdsSet(),
                getCurrentBetByMarketIdsAndStateDTO.getAccountId(),
                getCurrentBetByMarketIdsAndStateDTO.getTimeRange(),
                getCurrentBetByMarketIdsAndStateDTO.getOrderProjection()
        );
    }

    @PostMapping(path = "/getPastBetId", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<Long> getPastBetId(@RequestHeader HttpHeaders httpHeaders, @RequestBody GetPastBetIdDTO getPastBetIdDTO) {
        LOG.debug("/getPastBetId");
        LOG.debug(getPastBetIdDTO.toString());
        return betByMarketService.getPastBetId(
                getPastBetIdDTO.getSelectColumns(),
                getPastBetIdDTO.getState(),
                getPastBetIdDTO.getAccountId(),
                getPastBetIdDTO.getTimeRange()
        );
    }

    @PostMapping(path = "/getPastBetIdByEventTypeIds", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<Long> getPastBetIdByEventTypeIds(@RequestHeader HttpHeaders httpHeaders, @RequestBody GetPastBetIdByEventTypeIdsDTO getPastBetIdByEventTypeIdsDTO) {
        LOG.debug("/getPastBetIdByEventTypeIds");
        LOG.debug(getPastBetIdByEventTypeIdsDTO.toString());
        return betByMarketService.getPastBetIdByEventTypeIds(
                getPastBetIdByEventTypeIdsDTO.getSelectColumns(),
                getPastBetIdByEventTypeIdsDTO.getState(),
                getPastBetIdByEventTypeIdsDTO.getEventTypeIdsSet(),
                getPastBetIdByEventTypeIdsDTO.getAccountId(),
                getPastBetIdByEventTypeIdsDTO.getTimeRange()
        );
    }

    @PostMapping(path = "/getPastBetIdByEventIds", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<Long> getPastBetIdByEventIds(@RequestHeader HttpHeaders httpHeaders, @RequestBody GetPastBetIdByEventIdsDTO getPastBetIdByEventIdsDTO) {
        LOG.debug("/getPastBetIdByEventIds");
        LOG.debug(getPastBetIdByEventIdsDTO.toString());
        return betByMarketService.getPastBetIdByEventIds(
                getPastBetIdByEventIdsDTO.getSelectColumns(),
                getPastBetIdByEventIdsDTO.getState(),
                getPastBetIdByEventIdsDTO.getEventIdsSet(),
                getPastBetIdByEventIdsDTO.getAccountId(),
                getPastBetIdByEventIdsDTO.getTimeRange()
        );
    }

    @PostMapping(path = "/getPastBetIdByMarketIds", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<Long> getPastBetIdByMarketIds(@RequestHeader HttpHeaders httpHeaders, @RequestBody GetPastBetIdByMarketIdsDTO getPastBetIdByMarketIdsDTO) {
        LOG.debug("/getPastBetIdByMarketIds");
        LOG.debug(getPastBetIdByMarketIdsDTO.toString());
        return betByMarketService.getPastBetIdByMarketIds(
                getPastBetIdByMarketIdsDTO.getSelectColumns(),
                getPastBetIdByMarketIdsDTO.getState(),
                getPastBetIdByMarketIdsDTO.getMarketIdsSet(),
                getPastBetIdByMarketIdsDTO.getAccountId(),
                getPastBetIdByMarketIdsDTO.getTimeRange()
        );
    }

    @PostMapping(path = "/getPastBetIdByBetIds", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<Long> getPastBetIdByBetIds(@RequestHeader HttpHeaders httpHeaders, @RequestBody GetPastBetIdByBetIdsDTO getPastBetIdByBetIdsDTO) {
        LOG.debug("/getPastBetIdByBetIds");
        LOG.debug(getPastBetIdByBetIdsDTO.toString());
        return betByMarketService.getPastBetIdByBetIds(
                getPastBetIdByBetIdsDTO.getSelectColumns(),
                getPastBetIdByBetIdsDTO.getState(),
                getPastBetIdByBetIdsDTO.getBetIdsSet(),
                getPastBetIdByBetIdsDTO.getAccountId(),
                getPastBetIdByBetIdsDTO.getTimeRange()
        );
    }

    @PostMapping(path = "/getBetByBetId", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<BetByMarket> getBetByBetId(@RequestHeader HttpHeaders httpHeaders, @RequestBody List<Long> betIdsList) {
        LOG.debug("/getBetIdByBetIds");
        LOG.debug(betIdsList.toString());
        return betByMarketService.getBetByBetId(betIdsList);
    }

    @PostMapping(path = "/getBetBySelectionId", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<BetByMarket> getBetBySelectionId(@RequestHeader HttpHeaders httpHeaders, @RequestBody List<Long> selectionIdsList) {
        LOG.debug("/getBetBySelectionId");
        LOG.debug(selectionIdsList.toString());
        return betByMarketService.getBetBySelectionId(selectionIdsList);
    }

    @PostMapping(path = "/getBetByMarketId", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<BetByMarket> getBetByMarketId(@RequestHeader HttpHeaders httpHeaders, @RequestBody List<Long> marketIdsList) {
        LOG.debug("/getBetByMarketId");
        LOG.debug(marketIdsList.toString());
        return betByMarketService.getBetByMarketId(marketIdsList);
    }

    @PostMapping(path = "/getBetByEventId", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<BetByMarket> getBetByEventId(@RequestHeader HttpHeaders httpHeaders, @RequestBody List<Long> eventIdsList) {
        LOG.debug("/getBetByEventId");
        LOG.debug(eventIdsList.toString());
        return betByMarketService.getBetByEventId(eventIdsList);
    }

    @PostMapping(path = "/getBetByEventTypeId", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<BetByMarket> getBetByEventTypeId(@RequestHeader HttpHeaders httpHeaders, @RequestBody List<Long> eventTypeIdsList) {
        LOG.debug("/getBetByEventTypeId");
        LOG.debug(eventTypeIdsList.toString());
        return betByMarketService.getBetByEventTypeId(eventTypeIdsList);
    }

    @GetMapping(path = "/getSumOfSizeMatchedByMarketId/{marketId}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public double getSumOfSizeMatchedByMarketId(@PathVariable(value = "marketId") String marketId) {
        LOG.debug("/getSumOfSizeMatchedByMarketId");
        LOG.debug(marketId);
        double result = betByMarketService.getSumOfSizeMatchedByMarketId(marketId);
        return result;
    }

    @GetMapping(path = "/getBetIdsByAccountId/{accountId}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Set<Long> getBetIdsByAccountId(@PathVariable(value = "accountId") Long accountId) {
        LOG.debug("getBetIdsByAccountId:" + accountId);
        Set<Long> betIds = betByMarketService.getBetIdsByAccountId(accountId);
        return betIds;
    }

    @GetMapping(path = "/getBetIdsByAccountIds/{accountIds}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Set<Long> getBetIdsByAccountIds(@PathVariable(value = "accountIds") Set<Long> accountIds) {
        LOG.debug("getBetIdsByAccountIds:" + accountIds);
        Set<Long> betIds = betByMarketService.getBetIdsByAccountIds(accountIds);
        return betIds;
    }

    @GetMapping(path = "/getBetById/{betId}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public BetByMarket getBetById(@PathVariable(value = "betId") Long betId) {
        LOG.debug("getBetById:" + betId);
        BetByMarket betByMarket = betByMarketService.getBetById(betId);
        return betByMarket;
    }

    @GetMapping(path = "/getBetsByIds/{betIds}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<BetByMarket> getBetById(@PathVariable(value = "betIds") Set<Long> betIds) {
        LOG.debug("getBetsByIds:" + betIds);
        List<BetByMarket> betByMarketList = betByMarketService.getBetsByIds(betIds);
        return betByMarketList;
    }
}
