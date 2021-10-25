package com.chlee1252.scheduledmap.transport.client.odsay;

import com.chlee1252.scheduledmap.transport.client.odsay.dto.Error;
import com.chlee1252.scheduledmap.transport.client.odsay.dto.Result;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OdsayTransitResponseV1 {
    private Result result;
    private List<Error> error;
}
