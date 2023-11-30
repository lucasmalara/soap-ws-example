package com.example.soap.example.schema;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.lang.reflect.Field;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "yerbaMate",
        propOrder = {
                "brand",
                "origin",
                "type"
        }
)
@Getter
@Setter
public class YerbaMate {
    @XmlElement(required = true)
    protected String brand;

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Country origin;

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected YerbaMateType type;

    @SneakyThrows(IllegalAccessException.class)
    public boolean isEmpty() {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.get(this) == null) {
                return true;
            }
        }
        return false;
    }

    public boolean isNotEmpty() {
        return !isEmpty();
    }
}
