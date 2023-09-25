package org.football.entities.locationEntities;

import org.football.entities.playerAndPositionEntities.Player;
import org.football.entities.playerAndPositionEntities.Team;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;

@Entity
@Table(name = "towns")
public class Town {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;

    @OneToMany(mappedBy = "town", targetEntity = Team.class)
    private Set<Team> teams;

    public Town() {}

    public Town(String name, Country country) {
        this.name = name;
        this.country = country;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Team> getTeams() {
        return Collections.unmodifiableSet(teams);
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }
}
