package com.mountbet.betservice.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mountbet.betservice.constant.Type;
import com.mountbet.betservice.dto.OrderChanged;
import com.mountbet.betservice.dto.SubscribeOrdersQueryRequest;
import com.mountbet.betservice.service.OrderUpdateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class OrderListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderListener.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private OrderUpdateService orderUpdateService;

    @PostConstruct
    public void init() {
        subscribeOrder();
    }

    @RabbitListener(queues = "#{'${spring.rabbitmq.subscribe-orders-routing-key}'}")
    public void handleOrderUpdated(byte[] messageByte) {
        String messageString = new String(messageByte);
        LOGGER.debug("Received:" + messageString);
        try {
            OrderChanged orderChanged = objectMapper.readValue(messageString, OrderChanged.class);
            orderUpdateService.convertAndSendOrdersUpdated(orderChanged.getOrderMarkets());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void subscribeOrder() {
        SubscribeOrdersQueryRequest subscribeOrdersQueryRequest = new SubscribeOrdersQueryRequest();
        subscribeOrdersQueryRequest.setType(Type.SUBSCRIBE_ORDERS);
        try {
            rabbitTemplate.convertAndSend(subscribeOrdersQueryRequest);
        } catch (AmqpException e) {
            e.printStackTrace();
        }
    }

}