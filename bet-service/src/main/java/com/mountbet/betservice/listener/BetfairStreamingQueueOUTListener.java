package com.mountbet.betservice.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mountbet.betservice.dto.CancelOrder.CancelExecutionReport;
import com.mountbet.betservice.dto.PlaceOrder.PlaceExecutionReport;
import com.mountbet.betservice.dto.ReplaceOrder.ReplaceExecutionReport;
import com.mountbet.betservice.dto.UpdateOrder.UpdateExecutionReport;
import com.mountbet.betservice.service.BetByMarketService;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.ChannelCallback;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class BetfairStreamingQueueOUTListener {
    private static final Logger LOG = LoggerFactory.getLogger(BetfairStreamingQueueOUTListener.class);

    @Autowired
    private BetByMarketService betByMarketService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "#{'${spring.rabbitmq.routing-key-place-order}'}")
    public void rabbitListenerPlaceOrders(Message msg) {
        try {
            String messageString = new String(msg.getBody(), StandardCharsets.UTF_8);
            PlaceExecutionReport placeExecutionReport = objectMapper.readValue(messageString, PlaceExecutionReport.class);
            betByMarketService.placeBet(placeExecutionReport);
            reply(msg, placeExecutionReport);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = "#{'${spring.rabbitmq.routing-key-cancel-order}'}")
    public void rabbitListenerCancelOrders(Message msg) {
        try {
            String messageString = new String(msg.getBody(), StandardCharsets.UTF_8);
            CancelExecutionReport cancelExecutionReport = objectMapper.readValue(messageString, CancelExecutionReport.class);
            betByMarketService.cancelBet(cancelExecutionReport);
            reply(msg, cancelExecutionReport);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = "#{'${spring.rabbitmq.routing-key-replace-order}'}")
    public void rabbitListenerReplaceOrders(Message msg) {
        try {
            String messageString = new String(msg.getBody(), StandardCharsets.UTF_8);
            ReplaceExecutionReport replaceExecutionReport = objectMapper.readValue(messageString, ReplaceExecutionReport.class);
            betByMarketService.replaceBet(replaceExecutionReport);
            reply(msg, replaceExecutionReport);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = "#{'${spring.rabbitmq.routing-key-update-order}'}")
    public void rabbitListenerUpdateOrders(Message msg) {
        try {
            String messageString = new String(msg.getBody(), StandardCharsets.UTF_8);
            UpdateExecutionReport updateExecutionReport = objectMapper.readValue(messageString, UpdateExecutionReport.class);
            betByMarketService.updateBet(updateExecutionReport);
            reply(msg, updateExecutionReport);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reply(Message msg, Object object) {
        rabbitTemplate.execute(new ChannelCallback<Object>() {
            @Override
            public Object doInRabbit(Channel channel) throws Exception {
                AMQP.BasicProperties replyProps = new AMQP.BasicProperties
                        .Builder()
                        .contentType("application/json")
                        .contentEncoding("utf-8")
                        .correlationId(msg.getMessageProperties().getCorrelationId())
                        .build();
                channel.basicPublish("", msg.getMessageProperties().getReplyTo(), replyProps, objectMapper.writeValueAsBytes(object));
                return null;
            }
        });
    }
}