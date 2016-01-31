/**
 * 
 */
package com.test.entity;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Debashish Mitra
 *
 */
@XmlRootElement
public class Country {

    @XmlElement
    private String code;
    @XmlElement
    private String name;
    @XmlElement
    private String continent;
    @XmlElement
    private String region;
    @XmlElement
    private float surfaceArea;
    @XmlElement
    private Integer independenceYear;
    @XmlElement
    private Integer population;
    @XmlElement
    private City capital;
    @XmlElement
    private Set<City> cities = new HashSet<City>();

    public Country() {

    }

    public String getCode() {
	return code;
    }

    public void setCode(String code) {
	this.code = code;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getContinent() {
	return continent;
    }

    public void setContinent(String continent) {
	this.continent = continent;
    }

    public String getRegion() {
	return region;
    }

    public void setRegion(String region) {
	this.region = region;
    }

    public float getSurfaceArea() {
	return surfaceArea;
    }

    public void setSurfaceArea(float surfaceArea) {
	this.surfaceArea = surfaceArea;
    }

    public Integer getIndependenceYear() {
	return independenceYear;
    }

    public void setIndependenceYear(Integer independenceYear) {
	this.independenceYear = independenceYear;
    }

    public Integer getPopulation() {
	return population;
    }

    public void setPopulation(Integer population) {
	this.population = population;
    }

    public City getCapital() {
	return capital;
    }

    public void setCapital(City capital) {
	this.capital = capital;
    }

    public Set<City> getCities() {
	return cities;
    }

    public void setCities(Set<City> cities) {
	this.cities = cities;
    }
}
