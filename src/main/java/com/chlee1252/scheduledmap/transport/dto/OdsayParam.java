package com.chlee1252.scheduledmap.transport.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OdsayParam {
    private String apiKey;
    private String output;
    private String startX;
    private String startY;
    private String endX;
    private String endY;
    private String OPT;
}
