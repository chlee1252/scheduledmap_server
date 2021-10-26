package com.chlee1252.scheduledmap.transport.service;

import com.chlee1252.scheduledmap.transport.client.odsay.OdsayClient;
import com.chlee1252.scheduledmap.transport.client.odsay.OdsayPolylineResponseV1;
import com.chlee1252.scheduledmap.transport.client.odsay.OdsayTransitResponseV1;
import com.chlee1252.scheduledmap.transport.client.odsay.dto.GraphPos;
import com.chlee1252.scheduledmap.transport.client.odsay.dto.Path;
import com.chlee1252.scheduledmap.transport.dto.OdsayParam;
import com.chlee1252.scheduledmap.transport.dto.OdsayPolylineParam;
import com.chlee1252.scheduledmap.transport.dto.PolylineResponseV1;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class OdsayTransitServiceImpl implements OdsayTransitService {

    private final OdsayClient odsayClient;

    public OdsayTransitServiceImpl(OdsayClient odsayClient) {
        this.odsayClient = odsayClient;
    }

    @Override
    public OdsayTransitResponseV1 getOdsayTotalData(OdsayParam param) throws Exception {
        OdsayTransitResponseV1 transitInfo = getOdsayTransitData(param);

        if (!transitInfo.getError().isEmpty()) {
            return transitInfo;
        }

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
        List<GraphPos> polyline = getPolyline(param);
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

    private List<GraphPos> getPolyline(OdsayPolylineParam param) throws Exception {
        ResponseEntity<OdsayPolylineResponseV1> response = odsayClient.getPolyLineData(
                param.getApiKey(),
                createMapObjectParam(param.getMapObject())
        );
        checkSuccess(response);
        return Objects.requireNonNull(response.getBody()).getResult().getLane().get(0).getSection().get(0).getGraphPos();
    }

    @Override
    public PolylineResponseV1 getOdsayPolylineData(OdsayPolylineParam param) throws Exception {
        List<GraphPos> graphPos = getPolyline(param);
        return PolylineResponseV1.of(graphPos);
    }

    private String createMapObjectParam(String mapObject) {
        return String.format("0:0@%s", mapObject);
    }
}
