package com.mountbet.betservice.client;

import com.mountbet.betservice.dto.NavigationDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class NavigationClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(NavigationClient.class);

    @Value("${navigation-service.url}")
    private String navigationServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    public NavigationDetail getMarketDetails(String marketId) {
        Map<String, String> params = new HashMap<>();
        params.put("marketId", marketId);
        NavigationDetail navigationDetail = restTemplate.getForObject(navigationServiceUrl + "/navigation/market/details/{marketId}", NavigationDetail.class, params);
        return navigationDetail;
    }

}