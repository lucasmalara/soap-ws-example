package com.example.soap.example.service;

import com.example.soap.example.entity.YerbaMateEntity;
import com.example.soap.example.persistence.YerbaMateRepository;
import com.example.soap.example.schema.YerbaMate;
import com.example.soap.example.utils.YerbaMateConverter;
import com.example.soap.example.utils.YerbaMateFactory;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class YerbaMateServiceImpl implements YerbaMateService {

    private final YerbaMateRepository yerbaMateRepository;
    private final YerbaMateFactory yerbaMateFactory;
    private final YerbaMateConverter yerbaMateConverter;

    @Autowired
    public YerbaMateServiceImpl(YerbaMateRepository yerbaMateRepository, YerbaMateFactory yerbaMateFactory, YerbaMateConverter yerbaMateConverter) {
        this.yerbaMateRepository = yerbaMateRepository;
        this.yerbaMateFactory = yerbaMateFactory;
        this.yerbaMateConverter = yerbaMateConverter;
    }

    @PostConstruct
    public void sampleData() {
        Collection<YerbaMate> examples = yerbaMateFactory.examplesRandomOrder();
        Collection<YerbaMateEntity> entities = yerbaMateConverter.convertToEntities(examples);
        yerbaMateRepository.saveAll(entities);
    }

    @Override
    public Optional<YerbaMate> findByBrand(String brand) {
        Optional<YerbaMateEntity> optionalEntity = yerbaMateRepository.findByBrand(brand);
        return optionalEntity.map(yerbaMateConverter::convertToDTO);
    }
}
