package com.mountbet.betservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mountbet.betservice.constant.State;
import com.mountbet.betservice.dto.*;
import com.mountbet.betservice.entity.BetByMarket;
import com.mountbet.betservice.entity.key.BetByMarketKey;
import com.mountbet.betservice.listener.OrderListener;
import com.mountbet.betservice.listener.WebSocketListener;
import com.mountbet.betservice.repository.BetByMarketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.socket.TextMessage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class OrderUpdateService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderUpdateService.class);

    @Autowired
    private BetByMarketRepository betByMarketRepository;

    @Autowired
    private WebSocketListener webSocketListener;

    @Autowired
    private OrderListener orderListener;

    @Autowired
    private ObjectMapper objectMapper;

    public void convertAndSendOrdersUpdated(List<OrderMarket> orderMarkets) {
        for (OrderMarket order : orderMarkets) {
            convertAndSendOrderUpdated(order);
        }
    }

    public void convertAndSendOrderUpdated(OrderMarket orderMarket) {
        OrderMarketSnap orderMarketSnap = orderMarket.getOrderMarketSnap();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setType("BU");
        List<BetUpdate> betUpdates = new ArrayList<>();
        for (OrderMarketRunnerSnap orderMarketRunnerSnap : orderMarketSnap.getOrderMarketRunners()) {
            Map<String, Order> unmatchedOrders = orderMarketRunnerSnap.getUnmatchedOrders();
            for (Map.Entry<String, Order> entry : unmatchedOrders.entrySet()) {
                String betId = entry.getKey();
                Order order = entry.getValue();
                BetByMarket betByMarket = updateBet(Long.valueOf(betId), order);
                if (betByMarket != null) {
                    BetUpdate betUpdate = convertToBetUpdate(betByMarket);
                    betUpdates.add(betUpdate);
                }
            }
        }
        orderDTO.setBetUpdates(betUpdates);

        if (orderDTO.getBetUpdates().size() > 0) {
            try {
                webSocketListener.sendMessageToUsers(new TextMessage(objectMapper.writeValueAsString(orderDTO)));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }

    private BetByMarket updateBet(Long betId, Order order) {
        BetByMarket betByMarket = betByMarketRepository.findBetByBetId(betId);
        if (betByMarket != null) {
            betByMarket.setPrice(new BigDecimal(order.getP()));
            betByMarket.setSize(new BigDecimal(order.getS()));
            if (order.getSm() != null && order.getSm() != 0) {
                betByMarket.setSizeMatched(new BigDecimal(order.getSm()));
                betByMarket.setMatchedDate(new Date());
            }
            if (order.getSc() != null && order.getSc() != 0) {
                betByMarket.setSizeCancelled(new BigDecimal(order.getSc()));
                betByMarket.setCancelledDate(new Date());
            }
            betByMarket.setSizeRemaining(new BigDecimal(order.getSr()));
            betByMarket.setSizeLapsed(new BigDecimal(order.getSl()));
            betByMarket.setSizeVoided(new BigDecimal(order.getSv()));
            betByMarketRepository.saveBet(betByMarket);
            if (betByMarket.getSizeMatched().compareTo(betByMarket.getSize()) == 0) {
                betByMarketRepository.deleteBet(betByMarket);
                BetByMarketKey betByMarketKey = betByMarket.getKey();
                betByMarketKey.setState(State.MATCHED);
                betByMarket.setKey(betByMarketKey);
                betByMarket.setMatchedDate(new Date());
                betByMarketRepository.saveBet(betByMarket);
            }
            if (betByMarket.getSizeCancelled().compareTo(betByMarket.getSize()) == 0) {
                betByMarketRepository.deleteBet(betByMarket);
                BetByMarketKey betByMarketKey = betByMarket.getKey();
                betByMarketKey.setState(State.CANCELLED);
                betByMarket.setKey(betByMarketKey);
                betByMarket.setCancelledDate(new Date());
                betByMarketRepository.saveBet(betByMarket);
            }
        }
        return betByMarket;
    }

    private BetUpdate convertToBetUpdate(BetByMarket betByMarket) {
        BetUpdate betUpdate = new BetUpdate();
        betUpdate.setUser(betByMarket.getKey().getAccountId());
        betUpdate.setBetId(betByMarket.getKey().getBetId());
        betUpdate.setMarketId(betByMarket.getKey().getMarketId());
        betUpdate.setSelectionId(betByMarket.getKey().getSelectionId());
        betUpdate.setHandicap(betByMarket.getHandicap());
        betUpdate.setPrice(betByMarket.getPrice());
        betUpdate.setSize(betByMarket.getSize());
        betUpdate.setSide(betByMarket.getKey().getSide());
        betUpdate.setPersistenceType(betByMarket.getPersistenceType());
        betUpdate.setPlacedDate(betByMarket.getKey().getPlacedDate());
        betUpdate.setMatchedDate(betByMarket.getMatchedDate());
        betUpdate.setSizeMatched(betByMarket.getSizeMatched());
        betUpdate.setSizeRemained(betByMarket.getSizeRemaining());
        betUpdate.setSizeCancelled(betByMarket.getSizeCancelled());
        betUpdate.setSizeLapsed(betByMarket.getSizeLapsed());
        betUpdate.setSizeVoided(betByMarket.getSizeVoided());
        return betUpdate;
    }
}