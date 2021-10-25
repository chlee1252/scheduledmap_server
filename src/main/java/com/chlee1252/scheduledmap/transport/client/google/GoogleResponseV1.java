package com.chlee1252.scheduledmap.transport.client.google;

import com.chlee1252.scheduledmap.transport.client.google.dto.Routes;

import java.util.List;

public class GoogleResponseV1 {
    private List<Routes> routes;
    private String status;

    public List<Routes> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Routes> routes) {
        this.routes = routes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
