package com.chlee1252.scheduledmap.transport.client.google.dto.transit;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transit {
    private TransitStop arrival_stop;
    private TransitTime arrival_time;
    private TransitStop departure_stop;
    private TransitTime departure_time;
    private String headsign;
    private String headway;
    private Line line;
    private int num_stops;
}
