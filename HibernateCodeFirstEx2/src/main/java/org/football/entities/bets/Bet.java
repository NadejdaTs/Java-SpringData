package org.football.entities.bets;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "bets")
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "bet_money")
    private BigDecimal betMoney;

    @Column(name = "date_time")
    private LocalDateTime dateTimeOfBet;

    @Column(name = "user_id")
    private User userId;

    public Bet() {}

    public Bet(BigDecimal betMoney, LocalDateTime dateTimeOfBet, User userId) {
        this.betMoney = betMoney;
        this.dateTimeOfBet = dateTimeOfBet;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getBetMoney() {
        return betMoney;
    }

    public void setBetMoney(BigDecimal betMoney) {
        this.betMoney = betMoney;
    }

    public LocalDateTime getDateTimeOfBet() {
        return dateTimeOfBet;
    }

    public void setDateTimeOfBet(LocalDateTime dateTimeOfBet) {
        this.dateTimeOfBet = dateTimeOfBet;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
}
