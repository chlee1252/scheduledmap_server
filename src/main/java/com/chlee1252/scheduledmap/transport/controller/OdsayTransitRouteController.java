package com.chlee1252.scheduledmap.transport.controller;

import com.chlee1252.scheduledmap.transport.client.odsay.OdsayTransitResponseV1;
import com.chlee1252.scheduledmap.transport.dto.OdsayParam;
import com.chlee1252.scheduledmap.transport.service.OdsayTransitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class OdsayTransitRouteController {

    private final OdsayTransitService odsayTransitService;

    public OdsayTransitRouteController(OdsayTransitService odsayTransitService) {
        this.odsayTransitService = odsayTransitService;
    }

    @GetMapping("/odsay/transit")
    public OdsayTransitResponseV1 getTotalTransitData(
            @RequestParam("apiKey") String apiKey,
            @RequestParam("output") String output,
            @RequestParam("SX") String startX,
            @RequestParam("SY") String startY,
            @RequestParam("EX") String endX,
            @RequestParam("EY") String endY,
            @RequestParam("OPT") String opt
    ) throws Exception {
        return odsayTransitService.getOdsayTotalData(createOdsayParam(apiKey, output, startX, startY, endX, endY, opt));
    }

    @GetMapping("odsay/transit/only")
    public OdsayTransitResponseV1 getTransitData(@RequestParam("apiKey") String apiKey,
                                                 @RequestParam("output") String output,
                                                 @RequestParam("SX") String startX,
                                                 @RequestParam("SY") String startY,
                                                 @RequestParam("EX") String endX,
                                                 @RequestParam("EY") String endY,
                                                 @RequestParam("OPT") String opt
    ) throws Exception {
        return odsayTransitService.getOdsayTransitData(createOdsayParam(apiKey, output, startX, startY, endX, endY, opt));
    }

    private OdsayParam createOdsayParam(String apiKey, String output, String startX, String startY, String endX, String endY, String opt) {
        OdsayParam param = new OdsayParam();
        param.setApiKey(apiKey);
        param.setOPT(opt);
        param.setEndX(endX);
        param.setEndY(endY);
        param.setOutput(output);
        param.setStartX(startX);
        param.setStartY(startY);
        return param;
    }
}
