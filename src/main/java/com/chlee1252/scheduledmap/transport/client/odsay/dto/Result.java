package com.chlee1252.scheduledmap.transport.client.odsay.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Result {
    private long searchType;
    private long outTrafficCheck;
    private long busCount;
    private long subwayCount;
    private long subwayBusCount;
    private List<Path> path;
}
