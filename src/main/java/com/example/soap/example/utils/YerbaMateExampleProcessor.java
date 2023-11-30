package com.example.soap.example.utils;

import com.example.soap.example.annotation.YerbaMateExample;
import com.example.soap.example.schema.YerbaMate;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Component
public class YerbaMateExampleProcessor {

    public YerbaMate yerbaMateExampleFromMethod(Method method, Object obj) throws InvocationTargetException, IllegalAccessException {
        if (isAnnotatedWithYerbaMateExample(method) &&
                method.invoke(obj) instanceof YerbaMate example) {
            return example;
        }
        return new YerbaMate();
    }

    public static boolean isAnnotatedWithYerbaMateExample(Method method) {
        return method != null && method.isAnnotationPresent(YerbaMateExample.class);
    }

    public boolean yerbaMateNonEmpty(YerbaMate mate) {
        if (mate == null) {
            return false;
        }
        return mate.isNotEmpty();
    }
}
