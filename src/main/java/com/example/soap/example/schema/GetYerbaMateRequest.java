package com.example.soap.example.schema;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"brand"})
@XmlRootElement(name = "getYerbaMateRequest")
@Getter
@Setter
public class GetYerbaMateRequest {
    @XmlElement(required = true)
    protected String brand;
}
