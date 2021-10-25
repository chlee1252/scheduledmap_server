package com.chlee1252.scheduledmap.transport.client.google;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "Google", url = "https://maps.googleapis.com/maps/api")
public interface GooglePlacesClient {

    @GetMapping(value = "/directions/json")
    ResponseEntity<GoogleResponseV1> getTransitRoutes(
            @RequestParam("key") String apiKey,
            @RequestParam("destination") String destination,
            @RequestParam("origin") String origin,
            @RequestParam("mode") String mode,
            @RequestParam("transit_mode") String transitMode,
            @RequestParam("language") String language
    );
}
