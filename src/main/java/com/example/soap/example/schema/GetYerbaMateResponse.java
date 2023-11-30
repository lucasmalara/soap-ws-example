package com.example.soap.example.schema;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"yerbaMate"})
@XmlRootElement(name = "getYerbaMateResponse")
@Getter
@Setter
public class GetYerbaMateResponse {
    @XmlElement(required = true)
    protected YerbaMate yerbaMate;
}
