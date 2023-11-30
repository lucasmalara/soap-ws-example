package com.example.soap.example.schema;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "yerbaMateType")
@XmlEnum
public enum YerbaMateType {

    /**
     * Known as 'con palo.'
     */
    @XmlEnumValue("elaborada")
    ELABORADA("elaborada"),

    /**
     * Known as 'sin palo'.
     */
    @XmlEnumValue("despalada")
    DESPALADA("despalada");
    private final String value;

    YerbaMateType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static YerbaMateType fromValue(String v) {
        for (YerbaMateType type: YerbaMateType.values()) {
            if (type.value.equals(v)) {
                return type;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
