package com.chlee1252.scheduledmap.transport.client.odsay.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OdsayResponse {
    private long searchType;
    private long outTrafficCheck;
    private long busCount;
    private long subwayCount;
    private long subwayBusCount;
    private long pointDistance;
//    private long startRadius;
//    private long endRadius;

}
