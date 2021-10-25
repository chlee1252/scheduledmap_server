package com.chlee1252.scheduledmap.transport.client.odsay;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "Odsey", url = "https://api.odsay.com/v1/api")
public interface OdsayClient {
//    @GetMapping(value = "/searchPubTransPathR")

}
