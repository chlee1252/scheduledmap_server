package com.chlee1252.scheduledmap.transport.service;

import com.chlee1252.scheduledmap.transport.client.odsay.OdsayTransitResponseV1;
import com.chlee1252.scheduledmap.transport.client.odsay.dto.Section;
import com.chlee1252.scheduledmap.transport.dto.OdsayParam;
import com.chlee1252.scheduledmap.transport.dto.OdsayPolylineParam;

import java.util.List;

public interface OdsayTransitService {
    OdsayTransitResponseV1 getOdsayTotalData(OdsayParam param) throws Exception;
    OdsayTransitResponseV1 getOdsayTransitData(OdsayParam param) throws Exception;
    List<Section> getOdsayPolylineData(OdsayPolylineParam param) throws Exception;
}
