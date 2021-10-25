package com.chlee1252.scheduledmap.transport.client.google.dto;

import com.chlee1252.scheduledmap.transport.client.google.dto.transit.Transit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Step {
    private GoogleTextValue distance;
    private GoogleTextValue duration;
    private LatLng end_location;
    private String html_instructions;
    private Polyline polyline;
    private LatLng start_location;
    private Transit transit_details;
    private String travel_mode;
}
