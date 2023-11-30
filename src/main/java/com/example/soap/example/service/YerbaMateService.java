package com.example.soap.example.service;

import com.example.soap.example.schema.YerbaMate;

import java.util.Optional;

public interface YerbaMateService {
    Optional<YerbaMate> findByBrand(String brand);
}
