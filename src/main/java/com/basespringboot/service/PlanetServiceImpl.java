package com.basespringboot.service;

import com.basespringboot.dto.PlanetDto;
import com.basespringboot.entity.Planet;
import com.basespringboot.repository.PlanetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PlanetServiceImpl implements PlanetService {

    private final PlanetRepository planetRepository;

    public PlanetServiceImpl(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    @Override
    public Planet save(PlanetDto dto) {
        Planet planet = new Planet();
        planet.setName(dto.getName());
        planet.setDistanceFromSun(dto.getDistanceFromSun());
        planet.setType(dto.getType());
        return planetRepository.save(planet);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Planet> findAll() {
        return planetRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Planet> findById(Long id) {
        return planetRepository.findById(id);
    }

    @Override
    public Optional<Planet> update(Long id, PlanetDto dto) {
        return planetRepository.findById(id).map(existingPlanet -> {
            existingPlanet.setName(dto.getName());
            existingPlanet.setDistanceFromSun(dto.getDistanceFromSun());
            existingPlanet.setType(dto.getType());
            return planetRepository.save(existingPlanet);
        });
    }

    @Override
    public boolean deleteById(Long id) {
        if (planetRepository.existsById(id)) {
            planetRepository.deleteById(id);
            return true;
        }
        return false;
    }
}