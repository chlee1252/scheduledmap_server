package com.chlee1252.scheduledmap.transport.client.odsay.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PathInfo {
    private long trafficDistance;
    private long totalWalk;
    private long totalTime;
    private long payment;
    private long busTransitCount;
    private long subwayTransitCount;
    private String firstStartStation;
    private String lastEndStation;
    private long totalDistance;
    private long totalWalkTime;

}
