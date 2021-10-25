package com.chlee1252.scheduledmap.transport.client.google.dto.transit;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Line {
    private String color;
    private String name;
    private String short_name;
    private String text_color;
    private Vehicle vehicle;
}
