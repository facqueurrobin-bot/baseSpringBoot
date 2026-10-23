package com.basespringboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "planets")
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double distanceFromSun;
    private String type;

    public Planet() {
    }

    public Planet(String name, Double distanceFromSun, String type) {
        this.name = name;
        this.distanceFromSun = distanceFromSun;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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