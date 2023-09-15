package org.football.entities.playerAndPositionEntities;

import org.football.entities.enums.PositionId;

import javax.persistence.*;

@Entity
@Table(name = "positions")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private PositionId id;

    private String positionDescription;

    public Position(PositionId id, String positionDescription) {
        this.id = id;
        this.positionDescription = positionDescription;
    }

    public PositionId getId() {
        return id;
    }

    public void setId(PositionId id) {
        this.id = id;
    }

    public String getPositionDescription() {
        return positionDescription;
    }

    public void setPositionDescription(String positionDescription) {
        this.positionDescription = positionDescription;
    }
}
