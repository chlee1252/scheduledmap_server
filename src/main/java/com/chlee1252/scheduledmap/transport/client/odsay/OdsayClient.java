package com.chlee1252.scheduledmap.transport.client.odsay;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "Odsey", url = "https://api.odsay.com/v1/api")
public interface OdsayClient {
    // TODO: 이거 receive가 안됨.. 확인하기
    @GetMapping(value = "/searchPubTransPathR")
    ResponseEntity<OdsayTransitResponseV1> getTransportPath(
            @RequestParam("apiKey") String apiKey,
            @RequestParam("output") String output,
            @RequestParam("SX") String startX,
            @RequestParam("SY") String startY,
            @RequestParam("EX") String endX,
            @RequestParam("EY") String endY,
            @RequestParam("OPT") String OPT
    );

    @GetMapping(value = "/loadLane")
    ResponseEntity<OdsayPolylineResponseV1> getPolyLineData(
            @RequestParam("apiKey") String apiKey,
            @RequestParam("mapObject") String mapObject
    );

}
