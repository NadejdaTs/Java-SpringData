package org.football.entities.bets;

import org.football.entities.GamesAndCompetition.Game;
import org.football.entities.enums.Prediction;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;

@Entity
@Table(name = "bet_games")
public class BetGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //not sure
    private int id;

    @Column(name = "game_id")
    @ManyToOne(optional = false)
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private Game gameId;

    @Column(name = "bet_id")
    @ManyToOne(optional = false)
    @JoinColumn(name = "bet_id", referencedColumnName = "id")
    private Bet betId;

    //result_predictions_id with or without s
    @Column(name = "result_prediction")
    @OneToOne(optional = false)
    @JoinColumn(name = "result_predictions_id", referencedColumnName = "id")
    private Prediction resultPrediction;

    @ManyToMany(mappedBy = "game_id", targetEntity = Game.class)
    private Set<Game> games;

    public BetGame() {}

    public BetGame(Game gameId, Bet betId, Prediction resultPrediction) {
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

    public Prediction getResultPrediction() {
        return resultPrediction;
    }

    public void setResultPrediction(Prediction resultPrediction) {
        this.resultPrediction = resultPrediction;
    }

    public Set<Game> getGames() {
        return Collections.unmodifiableSet(games);
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}
