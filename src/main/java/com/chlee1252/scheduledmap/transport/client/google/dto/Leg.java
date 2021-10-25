package com.chlee1252.scheduledmap.transport.client.google.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Leg {
    private Time arrival_time;
    private Time departure_time;
    private GoogleTextValue distance;
    private GoogleTextValue duration;
    private String end_address;
    private LatLng end_location;
    private String start_address;
    private LatLng start_location;
    private List<Step> steps;
}
