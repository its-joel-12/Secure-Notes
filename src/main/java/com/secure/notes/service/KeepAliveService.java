package com.secure.notes.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class KeepAliveService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${test.api}")
    private String URL;

    // Ping once at startup
    @PostConstruct
    public void init() {
        ping();
    }

    // Ping every 10 minutes (600000 ms)
    @Scheduled(fixedRate = 600000)
    public void ping() {
        try {
            String response = restTemplate.getForObject(URL, String.class);
            System.out.println("Pinged KeepAlive URL: " + response);
        } catch (Exception e) {
            System.err.println("Error pinging KeepAlive URL: " + e.getMessage());
        }
    }
}
