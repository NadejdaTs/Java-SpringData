package org.football.entities.GamesAndCompetition;

import org.football.entities.playerAndPositionEntities.Team;
import org.football.entities.bets.Bet;
import org.football.entities.bets.BetGame;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "home_team")
    private Team homeTeam;

    @Column(name = "away_team")
    private Team AwayTeam;

    @Column(name = "home_team_goals")
    private int homeGoals;

    @Column(name = "away_team_goals")
    private int awayGoals;

    @Column(name = "date_time")
    private LocalDateTime dateTimeOfGame;

    @Column(name = "home_team_win_bet_rate")
    private Bet homeTeamRate;

    @Column(name = "away_team_win_bet_rate")
    private Bet awayTeamRate;

    @Column(name = "draw_game_bet_rate")
    private BetGame drawGameBetRate;

    @Column(name = "round_id")
    private Round roundId;

    @Column(name = "competition_id")
    private Competition competitionId;

    public Game() {}

    public Game(Team homeTeam, Team awayTeam, int homeGoals, int awayGoals, LocalDateTime dateTimeOfGame,
                Bet homeTeamRate, Bet awayTeamRate, BetGame drawGameBetRate, Round roundId, Competition competitionId) {
        this.homeTeam = homeTeam;
        AwayTeam = awayTeam;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
        this.dateTimeOfGame = dateTimeOfGame;
        this.homeTeamRate = homeTeamRate;
        this.awayTeamRate = awayTeamRate;
        this.drawGameBetRate = drawGameBetRate;
        this.roundId = roundId;
        this.competitionId = competitionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return AwayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        AwayTeam = awayTeam;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }

    public int getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(int awayGoals) {
        this.awayGoals = awayGoals;
    }

    public LocalDateTime getDateTimeOfGame() {
        return dateTimeOfGame;
    }

    public void setDateTimeOfGame(LocalDateTime dateTimeOfGame) {
        this.dateTimeOfGame = dateTimeOfGame;
    }

    public Bet getHomeTeamRate() {
        return homeTeamRate;
    }

    public void setHomeTeamRate(Bet homeTeamRate) {
        this.homeTeamRate = homeTeamRate;
    }

    public Bet getAwayTeamRate() {
        return awayTeamRate;
    }

    public void setAwayTeamRate(Bet awayTeamRate) {
        this.awayTeamRate = awayTeamRate;
    }

    public BetGame getDrawGameBetRate() {
        return drawGameBetRate;
    }

    public void setDrawGameBetRate(BetGame drawGameBetRate) {
        this.drawGameBetRate = drawGameBetRate;
    }

    public Round getRoundId() {
        return roundId;
    }

    public void setRoundId(Round roundId) {
        this.roundId = roundId;
    }

    public Competition getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(Competition competitionId) {
        this.competitionId = competitionId;
    }
}
