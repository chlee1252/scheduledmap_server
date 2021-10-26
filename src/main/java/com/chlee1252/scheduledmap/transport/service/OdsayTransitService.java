package com.chlee1252.scheduledmap.transport.service;

import com.chlee1252.scheduledmap.transport.client.odsay.OdsayTransitResponseV1;
import com.chlee1252.scheduledmap.transport.dto.OdsayParam;
import com.chlee1252.scheduledmap.transport.dto.OdsayPolylineParam;
import com.chlee1252.scheduledmap.transport.dto.PolylineResponseV1;

public interface OdsayTransitService {
    OdsayTransitResponseV1 getOdsayTotalData(OdsayParam param) throws Exception;
    OdsayTransitResponseV1 getOdsayTransitData(OdsayParam param) throws Exception;
    PolylineResponseV1 getOdsayPolylineData(OdsayPolylineParam param) throws Exception;
}
