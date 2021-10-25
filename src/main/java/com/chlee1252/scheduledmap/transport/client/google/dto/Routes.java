package com.chlee1252.scheduledmap.transport.client.google.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Routes {
    private List<Leg> legs;
}
