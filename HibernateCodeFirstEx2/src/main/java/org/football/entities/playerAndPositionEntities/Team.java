package org.football.entities.playerAndPositionEntities;

import org.football.entities.enums.LetterInitials;
import org.football.entities.locationEntities.Town;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Set;

@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name = "initials")
    private LetterInitials letterInitials;

    @Column(name = "primary_kit_color")
    private Color primaryKitColor;

    @Column(name = "secondary_kit_color")
    private Color secondaryKitColor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "town_id", referencedColumnName = "id")
    private Town town;
    private BigDecimal budget;

    @ManyToOne(optional = false)
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    private Set<Player> players;

    public Team() {}

    public Team(String name, LetterInitials letterInitials, Color primaryKitColor, Color secondaryKitColor, Town town, BigDecimal budget) {
        this.name = name;
        this.letterInitials = letterInitials;
        this.primaryKitColor = primaryKitColor;
        this.secondaryKitColor = secondaryKitColor;
        this.town = town;
        this.budget = budget;
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

    public LetterInitials getLetterInitials() {
        return letterInitials;
    }

    public void setLetterInitials(LetterInitials letterInitials) {
        this.letterInitials = letterInitials;
    }

    public Color getPrimaryKitColor() {
        return primaryKitColor;
    }

    public void setPrimaryKitColor(Color primaryKitColor) {
        this.primaryKitColor = primaryKitColor;
    }

    public Color getSecondaryKitColor() {
        return secondaryKitColor;
    }

    public void setSecondaryKitColor(Color secondaryKitColor) {
        this.secondaryKitColor = secondaryKitColor;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public Set<Player> getPlayers() {
        return Collections.unmodifiableSet(players);
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}
