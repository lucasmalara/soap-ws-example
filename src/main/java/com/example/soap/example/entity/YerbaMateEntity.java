package com.example.soap.example.entity;

import com.example.soap.example.schema.Country;
import com.example.soap.example.schema.YerbaMateType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "yerba_mate")
public class YerbaMateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(unique = true, nullable = false)
    protected String brand;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    protected Country origin;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    protected YerbaMateType type;
}
