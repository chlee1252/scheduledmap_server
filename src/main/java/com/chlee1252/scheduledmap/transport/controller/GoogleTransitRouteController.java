package com.chlee1252.scheduledmap.transport.controller;

import com.chlee1252.scheduledmap.transport.client.google.GoogleResponseV1;
import com.chlee1252.scheduledmap.transport.dto.GoogleParam;
import com.chlee1252.scheduledmap.transport.service.GoogleTransitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class GoogleTransitRouteController {

    private final GoogleTransitService googleTransitService;

    public GoogleTransitRouteController(GoogleTransitService googleTransitService) {
        this.googleTransitService = googleTransitService;
    }

    @GetMapping(value = "/transit")
    public GoogleResponseV1 getTransit(@RequestParam("key") String apiKey,
                                       @RequestParam("destination") String destination,
                                       @RequestParam("origin") String origin) throws Exception {
        GoogleParam param = new GoogleParam();
        param.setApiKey(apiKey);
        param.setDestination(destination);
        param.setLanguage("ko");
        param.setMode("transit");
        param.setTransitMode("bus|subway");
        param.setOrigin(origin);
        return googleTransitService.getTransit(param);
    }
}
