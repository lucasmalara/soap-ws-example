package com.example.soap.example.schema;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "country")
@XmlEnum
public enum Country {

    @XmlEnumValue("Argentina")
    ARGENTINA("Argentina"),
    @XmlEnumValue("Brazil")
    BRAZIL("Brazil"),
    @XmlEnumValue("Paraguay")
    PARAGUAY("Paraguay");
    private final String value;

    Country(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Country fromValue(String v) {
        for (Country c: Country.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
