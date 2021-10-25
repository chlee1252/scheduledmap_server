package com.chlee1252.scheduledmap.transport.client.odsay.dto.polyline;

import com.chlee1252.scheduledmap.transport.client.odsay.dto.Section;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Lane {
    private int type;
    private List<Section> section;
}
