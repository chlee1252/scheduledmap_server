package com.chlee1252.scheduledmap.transport.service;

import com.chlee1252.scheduledmap.transport.client.odsay.OdsayClient;
import com.chlee1252.scheduledmap.transport.client.odsay.OdsayPolylineResponseV1;
import com.chlee1252.scheduledmap.transport.client.odsay.OdsayTransitResponseV1;
import com.chlee1252.scheduledmap.transport.client.odsay.dto.GraphPos;
import com.chlee1252.scheduledmap.transport.client.odsay.dto.Path;
import com.chlee1252.scheduledmap.transport.dto.OdsayParam;
import com.chlee1252.scheduledmap.transport.dto.OdsayPolylineParam;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdsayTransitServiceImpl implements OdsayTransitService {

    private final OdsayClient odsayClient;

    public OdsayTransitServiceImpl(OdsayClient odsayClient) {
        this.odsayClient = odsayClient;
    }

    @Override
    public OdsayTransitResponseV1 getOdsayTotalData(OdsayParam param) throws Exception {
        OdsayTransitResponseV1 transitInfo = getOdsayTransitData(param);
        setPolylineDataToPath(transitInfo, param);
        return transitInfo;
    }

    private void setPolylineDataToPath(OdsayTransitResponseV1 transitInfo, OdsayParam param) throws Exception {
        List<Path> paths = transitInfo.getResult().getPath();

        for (Path path : paths) {
            addPolylineData(path, createPolylineParam(path, param));
        }
    }

    private void addPolylineData(Path path, OdsayPolylineParam param) throws Exception {
        List<GraphPos> polyline = getOdsayPolylineData(param);
        path.setPolyline(polyline);
    }

    private OdsayPolylineParam createPolylineParam(Path path, OdsayParam odsayParam) {
        OdsayPolylineParam param = new OdsayPolylineParam();
        param.setApiKey(odsayParam.getApiKey());
        param.setMapObject(path.getInfo().getMapObj());
        return param;
    }

    @Override
    public OdsayTransitResponseV1 getOdsayTransitData(OdsayParam param) throws Exception {
        ResponseEntity<OdsayTransitResponseV1> response = odsayClient.getTransportPath(
                param.getApiKey(),
                param.getOutput(),
                param.getStartX(),
                param.getStartY(),
                param.getEndX(),
                param.getEndY(),
                param.getOPT()
        );

        checkSuccess(response);
        return response.getBody();
    }

    private void checkSuccess(ResponseEntity response) throws Exception {
        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new Exception("Odsay 정보 가져오기 실패!");
        }
    }

    @Override
    public List<GraphPos> getOdsayPolylineData(OdsayPolylineParam param) throws Exception {
        ResponseEntity<OdsayPolylineResponseV1> response = odsayClient.getPolyLineData(
                param.getApiKey(),
                createMapObjectParam(param.getMapObject())
        );
        checkSuccess(response);
        return response.getBody().getResult().getLane().get(0).getSection().get(0).getGraphPos();
    }

    private String createMapObjectParam(String mapObject) {
        return String.format("0:0@%s", mapObject);
    }
}