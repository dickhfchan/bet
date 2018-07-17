package com.mountbet.betservice.listener;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mountbet.betservice.dto.CancelOrder.CancelExecutionReport;
import com.mountbet.betservice.dto.PlaceOrder.PlaceExecutionReport;
import com.mountbet.betservice.dto.ReplaceOrder.ReplaceExecutionReport;
import com.mountbet.betservice.dto.UpdateOrder.UpdateExecutionReport;
import com.mountbet.betservice.service.BetByMarketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;

/**
 * @author AnsonChan
 * @since 4/7/2018
 */
@Component
public class BetfairStreamingQueueOUTListener {
    private static final Logger LOG = LoggerFactory.getLogger(BetfairStreamingQueueOUTListener.class);

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private BetByMarketService betByMarketService;

    @PostConstruct
    public void init() {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @RabbitListener(queues = "#{'${spring.rabbitmq.routing-key-place-order}'}")
    public void rabbitListenerPlaceOrders(Message msg) {
        try {
            String messageString = new String(msg.getBody(), StandardCharsets.UTF_8);
            LOG.debug("messageString:" + messageString);
            LOG.debug("PLACE_ORDERS");
            PlaceExecutionReport placeExecutionReport = mapper.readValue(messageString, PlaceExecutionReport.class);
            betByMarketService.placeBet(placeExecutionReport);
        } catch (Exception e) {
            LOG.error("rabbitListenerPlaceOrders rabbitListener", e);
        }
    }

    @RabbitListener(queues = "#{'${spring.rabbitmq.routing-key-cancel-order}'}")
    public void rabbitListenerCancelOrders(Message msg) {
        try {
            String messageString = new String(msg.getBody(), StandardCharsets.UTF_8);
            LOG.debug("messageString:" + messageString);
            LOG.debug("CANCEL_ORDERS");
            CancelExecutionReport cancelExecutionReport = mapper.readValue(messageString, CancelExecutionReport.class);
            betByMarketService.cancelBet(cancelExecutionReport);
        } catch (Exception e) {
            LOG.error("rabbitListenerCancelOrders rabbitListener", e);
        }
    }

    @RabbitListener(queues = "#{'${spring.rabbitmq.routing-key-replace-order}'}")
    public void rabbitListenerReplaceOrders(Message msg) {
        try {
            String messageString = new String(msg.getBody(), StandardCharsets.UTF_8);
            LOG.debug("messageString:" + messageString);
            LOG.debug("REPLACE_ORDERS");
            ReplaceExecutionReport replaceExecutionReport = mapper.readValue(messageString, ReplaceExecutionReport.class);
            betByMarketService.replaceBet(replaceExecutionReport);
        } catch (Exception e) {
            LOG.error("rabbitListenerReplaceOrders rabbitListener", e);
        }
    }

    @RabbitListener(queues = "#{'${spring.rabbitmq.routing-key-update-order}'}")
    public void rabbitListenerUpdateOrders(Message msg) {
        try {
            String messageString = new String(msg.getBody(), StandardCharsets.UTF_8);
            LOG.debug("messageString:" + messageString);
            LOG.debug("UPDATE_ORDERS");
            UpdateExecutionReport updateExecutionReport = mapper.readValue(messageString, UpdateExecutionReport.class);
            betByMarketService.updateBet(updateExecutionReport);
        } catch (Exception e) {
            LOG.error("rabbitListenerUpdateOrders rabbitListener", e);
        }
    }
}