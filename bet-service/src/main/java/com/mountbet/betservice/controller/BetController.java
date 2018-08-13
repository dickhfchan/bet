package com.mountbet.betservice.controller;

import com.mountbet.betservice.dto.*;
import com.mountbet.betservice.entity.BetByMarket;
import com.mountbet.betservice.entity.BetByMarketForAccountService;
import com.mountbet.betservice.repository.BetByMarketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/bet")
@RestController
public class BetController {
    private static final Logger LOG = LoggerFactory.getLogger(BetController.class);

    @Autowired
    private BetByMarketRepository betByMarketRepository;

    @PostMapping(path = "/getCurrentBetByState", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<BetByMarket> getCurrentBetByState(@RequestHeader HttpHeaders httpHeaders, @RequestBody GetCurrentBetByStateDTO getCurrentBetByStateDTO) {
        LOG.debug("/getCurrentBetByState");
        LOG.debug(getCurrentBetByStateDTO.toString());
        return betByMarketRepository.getCurrentBetByState(
                getCurrentBetByStateDTO.getAccountId(),
                getCurrentBetByStateDTO.getTimeRange(),
                getCurrentBetByStateDTO.getOrderProjection()
        );
    }

    @PostMapping(path = "/getCurrentBetByMarketIdsAndState", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<BetByMarket> getCurrentBetByMarketIdsAndState(@RequestHeader HttpHeaders httpHeaders, @RequestBody GetCurrentBetByMarketIdsAndStateDTO getCurrentBetByMarketIdsAndStateDTO) {
        LOG.debug("/getCurrentBetByState");
        LOG.debug(getCurrentBetByMarketIdsAndStateDTO.toString());
        return betByMarketRepository.getCurrentBetByMarketIdsAndState(
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
        return betByMarketRepository.getPastBetId(
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
        return betByMarketRepository.getPastBetIdByEventTypeIds(
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
        return betByMarketRepository.getPastBetIdByEventIds(
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
        return betByMarketRepository.getPastBetIdByMarketIds(
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
        return betByMarketRepository.getPastBetIdByBetIds(
                getPastBetIdByBetIdsDTO.getSelectColumns(),
                getPastBetIdByBetIdsDTO.getState(),
                getPastBetIdByBetIdsDTO.getBetIdsSet(),
                getPastBetIdByBetIdsDTO.getAccountId(),
                getPastBetIdByBetIdsDTO.getTimeRange()
        );
    }

    @PostMapping(path = "/getPastBetByBetId", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<BetByMarketForAccountService> getPastBetByBetId(@RequestHeader HttpHeaders httpHeaders, @RequestBody List<Long> betIdsList) {
        LOG.debug("/getPastBetIdByBetIds");
        LOG.debug(betIdsList.toString());
        return betByMarketRepository.getPastBetByBetId(betIdsList);
    }

    @PostMapping(path = "/getPastBetBySelectionId", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<BetByMarketForAccountService> getPastBetBySelectionId(@RequestHeader HttpHeaders httpHeaders, @RequestBody List<Long> selectionIdsList) {
        LOG.debug("/getPastBetBySelectionId");
        LOG.debug(selectionIdsList.toString());
        return betByMarketRepository.getPastBetBySelectionId(selectionIdsList);
    }

    @PostMapping(path = "/getPastBetByMarketId", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<BetByMarketForAccountService> getPastBetByMarketId(@RequestHeader HttpHeaders httpHeaders, @RequestBody List<Long> marketIdsList) {
        LOG.debug("/getPastBetByMarketId");
        LOG.debug(marketIdsList.toString());
        return betByMarketRepository.getPastBetByMarketId(marketIdsList);
    }

    @PostMapping(path = "/getPastBetByEventId", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<BetByMarketForAccountService> getPastBetByEventId(@RequestHeader HttpHeaders httpHeaders, @RequestBody List<Long> eventIdsList) {
        LOG.debug("/getPastBetByEventId");
        LOG.debug(eventIdsList.toString());
        return betByMarketRepository.getPastBetByEventId(eventIdsList);
    }

    @PostMapping(path = "/getPastBetByEventTypeId", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<BetByMarketForAccountService> getPastBetByEventTypeId(@RequestHeader HttpHeaders httpHeaders, @RequestBody List<Long> eventTypeIdsList) {
        LOG.debug("/getPastBetByEventTypeId");
        LOG.debug(eventTypeIdsList.toString());
        return betByMarketRepository.getPastBetByEventTypeId(eventTypeIdsList);
    }

    @GetMapping(path = "/getSumOfSizeMatchedByMarketId/{marketId}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public double getSumOfSizeMatchedByMarketId(@PathVariable(value = "marketId") String marketId) {
        LOG.debug("/getSumOfSizeMatchedByMarketId");
        LOG.debug(marketId);
        double result = betByMarketRepository.getSumOfSizeMatchedByMarketId(marketId);
        return result;
    }
}