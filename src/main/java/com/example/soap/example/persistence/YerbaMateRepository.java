package com.example.soap.example.persistence;

import com.example.soap.example.entity.YerbaMateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface YerbaMateRepository extends JpaRepository<YerbaMateEntity, String> {
    Optional<YerbaMateEntity> findByBrand(String brand);
}
