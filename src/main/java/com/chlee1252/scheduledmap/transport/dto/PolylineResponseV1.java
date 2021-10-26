package com.chlee1252.scheduledmap.transport.dto;

import com.chlee1252.scheduledmap.transport.client.odsay.dto.GraphPos;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PolylineResponseV1 {
    private List<GraphPos> graph;

    public static PolylineResponseV1 of(List<GraphPos> graph) {
        PolylineResponseV1 responseV1 = new PolylineResponseV1();
        responseV1.setGraph(graph);
        return responseV1;
    }
}
