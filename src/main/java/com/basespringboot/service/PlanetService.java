package com.basespringboot.service;

import com.basespringboot.dto.PlanetDto;
import com.basespringboot.entity.Planet;

import java.util.List;
import java.util.Optional;

public interface PlanetService {
    Planet save(PlanetDto dto);
    List<Planet> findAll();
    Optional<Planet> findById(Long id);
    Optional<Planet> update(Long id, PlanetDto dto);
    boolean deleteById(Long id);
}