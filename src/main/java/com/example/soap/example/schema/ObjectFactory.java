package com.example.soap.example.schema;

import jakarta.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

    public GetYerbaMateRequest createGetYerbaMateRequest() {
        return new GetYerbaMateRequest();
    }

    public GetYerbaMateResponse createGetYerbaMateResponse() {
        return new GetYerbaMateResponse();
    }

    public YerbaMate createYerbaMate() {
        return new YerbaMate();
    }
}
