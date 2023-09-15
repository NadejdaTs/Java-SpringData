package org.football.entities.playerAndPositionEntities;

import org.football.entities.GamesAndCompetition.Game;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "playerStatistics")
public class PlayerStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Game game;
    private Player player;
    private float scoredGoals;
    private Player playerAssist;

    //PK is different
    private BigDecimal playedMinDuringGame;

    public PlayerStatistics() {}

    public PlayerStatistics(Game game, Player player, float scoredGoals, Player playerAssist, BigDecimal playedMinDuringGame) {
        this.game = game;
        this.player = player;
        this.scoredGoals = scoredGoals;
        this.playerAssist = playerAssist;
        this.playedMinDuringGame = playedMinDuringGame;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public float getScoredGoals() {
        return scoredGoals;
    }

    public void setScoredGoals(float scoredGoals) {
        this.scoredGoals = scoredGoals;
    }

    public Player getPlayerAssist() {
        return playerAssist;
    }

    public void setPlayerAssist(Player playerAssist) {
        this.playerAssist = playerAssist;
    }

    public BigDecimal getPlayedMinDuringGame() {
        return playedMinDuringGame;
    }

    public void setPlayedMinDuringGame(BigDecimal playedMinDuringGame) {
        this.playedMinDuringGame = playedMinDuringGame;
    }
}
