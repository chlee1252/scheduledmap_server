package com.chlee1252.scheduledmap.transport.client.odsay;

import com.chlee1252.scheduledmap.transport.client.odsay.dto.Error;
import com.chlee1252.scheduledmap.transport.client.odsay.dto.Path;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OdsayTransitResponseV1 {
    private long searchType;
    private long outTrafficCheck;
    private long busCount;
    private long subwayCount;
    private long subwayBusCount;
    private List<Path> path;
    private List<Error> error;
}
