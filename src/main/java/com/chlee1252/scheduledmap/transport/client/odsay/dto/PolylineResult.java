package com.chlee1252.scheduledmap.transport.client.odsay.dto;

import com.chlee1252.scheduledmap.transport.client.odsay.dto.polyline.Lane;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PolylineResult {
    private List<Lane> lane;

    private Boundary boundary;
}
