package com.chlee1252.scheduledmap.transport.client.google.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Time {
    private String text;
    private String time_zone;
    private long value;
}
