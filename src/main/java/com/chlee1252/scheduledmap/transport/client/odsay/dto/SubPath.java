package com.chlee1252.scheduledmap.transport.client.odsay.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SubPath {
    private int trafficType;
    private int distance;
    private int sectionTime;
    private int stationCount;
    private List<Lane> lane;
    private String startName;
    private String endName;
    private String startExitNo;
    private double startExitX;
    private double startExitY;
    private PassStop passStopList;
}
