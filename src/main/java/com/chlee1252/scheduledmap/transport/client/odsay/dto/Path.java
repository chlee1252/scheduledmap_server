package com.chlee1252.scheduledmap.transport.client.odsay.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Path {
    private long pathType;
    private PathInfo info;
    private List<SubPath> subPath;
    private List<GraphPos> polyline;
}
