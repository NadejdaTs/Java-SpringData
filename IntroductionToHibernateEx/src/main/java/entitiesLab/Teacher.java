package entitiesLab;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    @Column(name = "start_date")
    private LocalDate startedAt;

    public Teacher(){}
    public Teacher(String name, LocalDate startedAt){
        this.name = name;
        this.startedAt = startedAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartedAt(LocalDate startedAt) {
        this.startedAt = startedAt;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartedAt() {
        return startedAt;
    }
}
