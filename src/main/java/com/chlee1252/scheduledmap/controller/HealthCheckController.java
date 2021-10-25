package com.chlee1252.scheduledmap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class HealthCheckController {

    @GetMapping(value = "/health")
    public String healthCheck() {
        return "OK";
    }
}
