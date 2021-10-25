package com.chlee1252.scheduledmap.transport.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "Odsey", url = "https://api.odsay.com/v1/api")
public interface OdsayClient {
//    @GetMapping(value = "/searchPubTransPathR")

}
