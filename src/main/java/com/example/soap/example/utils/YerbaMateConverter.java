package com.example.soap.example.utils;

import com.example.soap.example.entity.YerbaMateEntity;
import com.example.soap.example.schema.YerbaMate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class YerbaMateConverter {

    private final ModelMapper modelMapper;

    @Autowired
    public YerbaMateConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public YerbaMate convertToDTO(YerbaMateEntity entity) {
        return modelMapper.map(entity, YerbaMate.class);
    }

    public YerbaMateEntity convertToEntity(YerbaMate dto) {
        return modelMapper.map(dto, YerbaMateEntity.class);
    }

    public Collection<YerbaMateEntity> convertToEntities(Collection<YerbaMate> dtoList) {
        return dtoList.stream()
                .map(this::convertToEntity)
                .toList();
    }

}
