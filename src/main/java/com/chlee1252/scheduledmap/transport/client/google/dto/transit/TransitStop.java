package com.chlee1252.scheduledmap.transport.client.google.dto.transit;

import com.chlee1252.scheduledmap.transport.client.google.dto.LatLng;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransitStop {
    private LatLng location;
    private String name;
}
