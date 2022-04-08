package com.example.demo2;

import org.springframework.data.annotation.Id;
import java.sql.Timestamp;

public class Country {
    @Id
    private String id;
    private int population;
    private double area;
    private String region;
    private Name name;

    public Country(String id, int population, double area, String region, Name name) {
        this.id = id;
        this.population = population;
        this.area = area;
        this.region = region;
        this.name = name;
    }

    public Country() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}
