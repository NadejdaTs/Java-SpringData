package org.football.entities.bets;

import org.football.entities.enums.Prediction;

import javax.persistence.*;

@Entity
@Table(name = "result_predictions")
public class ResultPrediction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Prediction prediction;

    public ResultPrediction() {}

    public ResultPrediction(Prediction prediction) {
        this.prediction = prediction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Prediction getPrediction() {
        return prediction;
    }

    public void setPrediction(Prediction prediction) {
        this.prediction = prediction;
    }
}
