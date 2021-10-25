package com.chlee1252.scheduledmap.transport.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/v1/api")
public class HealthCheckController {

    @GetMapping(value = "/health")
    public String healthCheck() {
        return "OK";
    }
}
