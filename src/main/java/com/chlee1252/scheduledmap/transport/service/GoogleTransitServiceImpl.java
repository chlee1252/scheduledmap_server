package com.chlee1252.scheduledmap.transport.service;

import com.chlee1252.scheduledmap.transport.client.google.GooglePlacesClient;
import com.chlee1252.scheduledmap.transport.client.google.GoogleResponseV1;
import com.chlee1252.scheduledmap.transport.dto.GoogleParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GoogleTransitServiceImpl implements GoogleTransitService {
    private final GooglePlacesClient googlePlacesClient;

    public GoogleTransitServiceImpl(GooglePlacesClient googlePlacesClient) {
        this.googlePlacesClient = googlePlacesClient;
    }

    @Override
    public GoogleResponseV1 getTransit(GoogleParam param) throws Exception {
        ResponseEntity<GoogleResponseV1> response = googlePlacesClient.getTransitRoutes(
                param.getApiKey(),
                param.getDestination(),
                param.getOrigin(),
                param.getMode(),
                param.getTransitMode(),
                param.getLanguage()
        );

        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new Exception("데이터 이상함..");
        }
        return response.getBody();
    }
}
