package org.football.entities.bets;

import org.football.entities.GamesAndCompetition.Game;

import javax.persistence.*;

@Entity
@Table(name = "bet_games")
public class BetGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //not sure
    private int id;

    @Column(name = "game_id")
    private Game gameId;

    @Column(name = "bet_id")
    private Bet betId;

    @Column(name = "result_prediction")
    private String resultPrediction;

    public BetGame() {}

    public BetGame(Game gameId, Bet betId, String resultPrediction) {
        this.gameId = gameId;
        this.betId = betId;
        this.resultPrediction = resultPrediction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Game getGameId() {
        return gameId;
    }

    public void setGameId(Game gameId) {
        this.gameId = gameId;
    }

    public Bet getBetId() {
        return betId;
    }

    public void setBetId(Bet betId) {
        this.betId = betId;
    }

    public String getResultPrediction() {
        return resultPrediction;
    }

    public void setResultPrediction(String resultPrediction) {
        this.resultPrediction = resultPrediction;
    }
}
