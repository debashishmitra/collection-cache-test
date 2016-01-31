/**
 * 
 */
package com.test.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Debashish Mitra
 *
 */
@XmlRootElement
public class City {

    @XmlElement
    private int id;
    @XmlElement
    private String name;
    @JsonIgnore
    @XmlElement
    private Country country;
    @XmlElement
    private String district;
    @XmlElement
    private Integer population;

    public City() {

    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Country getCountry() {
	return country;
    }

    public void setCountry(Country country) {
	this.country = country;
    }

    public String getDistrict() {
	return district;
    }

    public void setDistrict(String district) {
	this.district = district;
    }

    public Integer getPopulation() {
	return population;
    }

    public void setPopulation(Integer population) {
	this.population = population;
    }
}
