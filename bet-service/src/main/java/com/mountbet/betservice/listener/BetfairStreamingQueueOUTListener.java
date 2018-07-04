package com.mountbet.betservice.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mountbet.betservice.dto.PlaceOrder.PlaceExecutionReport;
import com.mountbet.betservice.dto.PlaceOrder.PlaceExecutionReportSource;
import com.mountbet.betservice.entity.BetByMarket;
import com.mountbet.betservice.service.BetByMarketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * @author AnsonChan
 * @since 4/7/2018
 */
@Component
public class BetfairStreamingQueueOUTListener {
    private static final Logger LOG = LoggerFactory.getLogger(BetfairStreamingQueueOUTListener.class);
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private BetByMarketService betByMarketService;

    @RabbitListener(queues = "BetfairStreamingQueueOUT")
    public void rabbitListener(Message msg) {
        String str = new String(msg.getBody(), StandardCharsets.UTF_8);
        try {
            PlaceExecutionReportSource orderUpdate = mapper.readValue(str, PlaceExecutionReportSource.class);
            PlaceExecutionReport placeExecutionReport = orderUpdate.getSource();
            LOG.debug(placeExecutionReport.toString());
            betByMarketService.newBet(placeExecutionReport);
        } catch (Exception e) {
            LOG.error("BetfairStreamingQueueOUTListener rabbitListener", e);
        }
    }
}
