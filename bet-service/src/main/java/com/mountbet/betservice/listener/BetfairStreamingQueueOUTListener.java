package com.mountbet.betservice.listener;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mountbet.betservice.dto.CancelOrder.CancelExecutionReport;
import com.mountbet.betservice.dto.CancelOrder.CancelExecutionReportSource;
import com.mountbet.betservice.dto.CancelOrder.CancelInstructionReport;
import com.mountbet.betservice.dto.PlaceOrder.PlaceExecutionReport;
import com.mountbet.betservice.dto.PlaceOrder.PlaceExecutionReportSource;
import com.mountbet.betservice.dto.PlaceOrder.PlaceInstructionReport;
import com.mountbet.betservice.dto.QueryRequest;
import com.mountbet.betservice.dto.QueryRequestSource;
import com.mountbet.betservice.entity.BetByMarket;
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

    @RabbitListener(queues = "BetfairStreamingQueueOUT")
    public void rabbitListener(Message msg) {
        try {
            String str = new String(msg.getBody(), StandardCharsets.UTF_8);
            QueryRequestSource queryRequestSource = mapper.readValue(str, QueryRequestSource.class);
            QueryRequest queryRequest = queryRequestSource.getSource();
            LOG.info("queryRequest:" + queryRequest.toString());
            switch (queryRequest.getCustomerRef()) {
                case PLACE_ORDERS:
                    LOG.debug("PLACE_ORDERS");
                    PlaceExecutionReportSource orderUpdate = mapper.readValue(str, PlaceExecutionReportSource.class);
                    PlaceExecutionReport placeExecutionReport = orderUpdate.getSource();
                    LOG.debug(placeExecutionReport.toString());
                    String marketID = placeExecutionReport.getMarketId();
                    for (PlaceInstructionReport placeInstructionReport : placeExecutionReport.getInstructionReports()) {
                        BetByMarket betByMarketCheckExist = betByMarketService.checkExist(marketID, placeInstructionReport.getBetId());
                        if (betByMarketCheckExist != null) {
                            LOG.debug("not null");
                            betByMarketService.updateBet(placeExecutionReport, betByMarketCheckExist.getKey());
                        } else {
                            betByMarketService.newBet(placeExecutionReport);
                        }
                    }
                    break;
                case CANCEL_ORDERS:
                    LOG.debug("CANCEL_ORDERS");
                    CancelExecutionReportSource cancelExecutionReportSource = mapper.readValue(str, CancelExecutionReportSource.class);
                    CancelExecutionReport cancelExecutionReport = cancelExecutionReportSource.getSource();
                    for (CancelInstructionReport cancelInstructionReport : cancelExecutionReport.getInstructionReports()) {
                        betByMarketService.cancelBet(cancelExecutionReport.getMarketId(), cancelInstructionReport);
                    }
                    break;
            }
        } catch (Exception e) {
            LOG.error("BetfairStreamingQueueOUTListener rabbitListener", e);
        }
    }
}