package org.football.entities.playerAndPositionEntities;

import org.football.entities.GamesAndCompetition.Game;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name = "squad_number")
    private int squadNumber;

    @Column(name = "team_id")
    private Team teamId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position positionId;
    private boolean isCurrInjured;

    @ManyToMany(mappedBy = "players", targetEntity = Game.class)
    private Set<Game> games;

    public Player() {}

    public Player(String name, int squadNumber, Team teamId, Position positionId, boolean isCurrInjured) {
        this.name = name;
        this.squadNumber = squadNumber;
        this.teamId = teamId;
        this.positionId = positionId;
        this.isCurrInjured = isCurrInjured;
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

    public int getSquadNumber() {
        return squadNumber;
    }

    public void setSquadNumber(int squadNumber) {
        this.squadNumber = squadNumber;
    }

    public Team getTeamId() {
        return teamId;
    }

    public void setTeamId(Team teamId) {
        this.teamId = teamId;
    }

    public Position getPositionId() {
        return positionId;
    }

    public void setPositionId(Position positionId) {
        this.positionId = positionId;
    }

    public boolean isCurrInjured() {
        return isCurrInjured;
    }

    public void setCurrInjured(boolean currInjured) {
        isCurrInjured = currInjured;
    }

    public Set<Game> getGames() {
        return Collections.unmodifiableSet(games);
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}
