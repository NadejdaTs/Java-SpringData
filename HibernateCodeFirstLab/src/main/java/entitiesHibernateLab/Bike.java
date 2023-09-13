package entitiesHibernateLab;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bikes")
@DiscriminatorValue(value = "bike")
public class Bike extends Vehicle{
    private static final String BIKE_TYPE = "Bike";
    @Column
    private int gearsCount;

    public Bike() {}

    public Bike(int gearsCount) {
        super(BIKE_TYPE, 250);
        this.gearsCount = gearsCount;
    }

    public int getGearsCount() {
        return gearsCount;
    }

    public void setGearsCount(int gearsCount) {
        this.gearsCount = gearsCount;
    }
}
