package com.basespringboot.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PlanetDto {

    @NotBlank(message = "Le nom de la planète est obligatoire")
    private String name;

    @NotNull(message = "La distance par rapport au soleil est obligatoire")
    private Double distanceFromSun;

    @NotBlank(message = "Le type de planète est obligatoire")
    private String type;

    public PlanetDto() {
    }

    public PlanetDto(String name, Double distanceFromSun, String type) {
        this.name = name;
        this.distanceFromSun = distanceFromSun;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDistanceFromSun() {
        return distanceFromSun;
    }

    public void setDistanceFromSun(Double distanceFromSun) {
        this.distanceFromSun = distanceFromSun;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}