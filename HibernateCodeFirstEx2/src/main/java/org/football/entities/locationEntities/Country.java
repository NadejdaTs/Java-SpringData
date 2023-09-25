package org.football.entities.locationEntities;

import org.football.entities.enums.CountryCode;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @Column(name = "country_code")
    private CountryCode countryCode;

    @ManyToMany
    @JoinTable(name = "country_continent",
            joinColumns = @JoinColumn(name = "county_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "continent_id", referencedColumnName = "id")
    )
    private Set<Continent> continent;

    @OneToMany(mappedBy = "town", targetEntity = Town.class)
    private Set<Town> towns;

    public Country() {}

    public Country(String name, CountryCode countryCode) {
        this.name = name;
        this.countryCode = countryCode;
//        this.continent = continent;
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

    public CountryCode getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(CountryCode countryCode) {
        this.countryCode = countryCode;
    }

    /*public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }*/
}
