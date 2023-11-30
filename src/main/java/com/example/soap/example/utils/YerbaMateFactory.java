package com.example.soap.example.utils;

import com.example.soap.example.annotation.YerbaMateExample;
import com.example.soap.example.schema.Country;
import com.example.soap.example.schema.YerbaMate;
import com.example.soap.example.schema.YerbaMateType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import static com.example.soap.example.schema.Country.*;
import static com.example.soap.example.schema.YerbaMateType.DESPALADA;
import static com.example.soap.example.schema.YerbaMateType.ELABORADA;

@Component
public class YerbaMateFactory {

    private static final Logger log = LoggerFactory.getLogger(YerbaMateFactory.class);
    private final YerbaMateExampleProcessor yerbaMateExampleProcessor;

    @Autowired
    public YerbaMateFactory(YerbaMateExampleProcessor yerbaMateExampleProcessor) {
        this.yerbaMateExampleProcessor = yerbaMateExampleProcessor;
    }

    private YerbaMate produce(String brand, YerbaMateType type, Country origin) {
        YerbaMate mate = new YerbaMate();
        mate.setBrand(brand);
        mate.setType(type);
        mate.setOrigin(origin);
        return mate;
    }

    public List<YerbaMate> examples() {
        List<YerbaMate> mateList = new ArrayList<>();
        try {
            Method[] methods = YerbaMateFactory.class.getDeclaredMethods();
            for (Method method : methods) {
                YerbaMate example = yerbaMateExampleProcessor.yerbaMateExampleFromMethod(method, this);
                boolean nonEmptyExample = yerbaMateExampleProcessor.yerbaMateNonEmpty(example);
                if (nonEmptyExample) {
                    log.info("{}", "New YerbaMate example created: " + example.getBrand());
                    mateList.add(example);
                }
            }
        } catch (InvocationTargetException | IllegalAccessException | SecurityException e) {
            log.debug(e.getLocalizedMessage());
        }
        return mateList;
    }


    public Collection<YerbaMate> examplesRandomOrder() {
        List<YerbaMate> examples = examples();
        Collections.shuffle(examples);
        return examples;
    }

    @YerbaMateExample
    public YerbaMate pajarito() {
        return produce("Pajarito Classic", ELABORADA, PARAGUAY);
    }

    @YerbaMateExample
    public YerbaMate taragui() {
        return produce("Taragui Classic", ELABORADA, ARGENTINA);
    }

    @YerbaMateExample
    public YerbaMate mateGreenFuerte() {
        return produce("Mate Green Fuerte", DESPALADA, BRAZIL);
    }

    @YerbaMateExample
    public YerbaMate selectaDespalada() {
        return produce("Selecta Despalada", DESPALADA, PARAGUAY);
    }

    @YerbaMateExample
    public YerbaMate rosamonte() {
        return produce("Rosamonte Classic", ELABORADA, ARGENTINA);
    }

    @YerbaMateExample
    public YerbaMate piporeDespalada() {
        return produce("Pipore Despalada", DESPALADA, ARGENTINA);
    }
}
