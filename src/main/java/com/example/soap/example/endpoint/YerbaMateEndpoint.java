package com.example.soap.example.endpoint;

import com.example.soap.example.schema.GetYerbaMateRequest;
import com.example.soap.example.schema.GetYerbaMateResponse;
import com.example.soap.example.schema.YerbaMate;
import com.example.soap.example.service.YerbaMateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.Optional;

@Endpoint
public class YerbaMateEndpoint {
    private final YerbaMateService yerbaMateService;

    @Autowired
    public YerbaMateEndpoint(YerbaMateService yerbaMateService) {
        this.yerbaMateService = yerbaMateService;
    }


    @PayloadRoot(
            namespace = "http://localhost:8080/soap-demo",
            localPart = "getYerbaMateRequest"
    )
    @ResponsePayload
    public GetYerbaMateResponse getYerbaMateByBrand(@RequestPayload GetYerbaMateRequest request) {
        Optional<YerbaMate> optionalYerbaMate = yerbaMateService.findByBrand(request.getBrand());
        GetYerbaMateResponse response = new GetYerbaMateResponse();
        optionalYerbaMate.ifPresent(response::setYerbaMate);
        return response;
    }
}
