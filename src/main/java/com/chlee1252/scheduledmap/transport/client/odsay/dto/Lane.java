package com.chlee1252.scheduledmap.transport.client.odsay.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Lane {
    private String name;
    private int subwayCode;
    private int subwayCityCode;
    private String busNo;
    private int type;
    private int busID;
}
