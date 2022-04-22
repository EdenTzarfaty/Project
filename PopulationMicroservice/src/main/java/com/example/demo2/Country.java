package com.example.demo2;

import org.springframework.data.annotation.Id;
import java.sql.Timestamp;

/* Country Class */
public class Country {

    private static int count; //for id country

    @Id
    private int id;

    private int population;
    private double area;
    private String region;
    private Name name;

    public Country() {
        this.id = ++count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
