package com.chlee1252.scheduledmap.transport.client.odsay;

import com.chlee1252.scheduledmap.transport.client.odsay.dto.PolylineResult;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OdsayPolylineResponseV1 {
    private PolylineResult result;
    private List<Error> error;
}
