package com.chlee1252.scheduledmap.transport.client.odsay;

import com.chlee1252.scheduledmap.transport.client.odsay.dto.Boundary;
import com.chlee1252.scheduledmap.transport.client.odsay.dto.DetailPath;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OdsayPolylineResponseV1 {
    private DetailPath lane;
    private Boundary boundary;
}
