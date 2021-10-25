package com.chlee1252.scheduledmap.transport.service;

import com.chlee1252.scheduledmap.transport.client.google.GoogleResponseV1;
import com.chlee1252.scheduledmap.transport.dto.GoogleParam;

public interface GoogleTransitService {
    GoogleResponseV1 getTransit(GoogleParam param) throws Exception;
}
