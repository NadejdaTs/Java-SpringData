package entitiesRelationships;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "shampoos")
public class BasicShampoo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToOne(optional = false)
    @JoinColumn(name = "label_id", referencedColumnName = "id")
    private BasicLabel label;

    @ManyToOne(optional = false)
    @JoinColumn(name = "batch_id", referencedColumnName = "id")
    private ProductionBatch batch;

    @ManyToMany
    @JoinTable(name = "shampoos_ingredients",
            joinColumns = @JoinColumn(name = "shampoo_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ingredients_id", referencedColumnName = "id"))
    private Set<BasicIngredient> ingredients;

    @ElementCollection
    private List<String> names;

    public BasicShampoo() {}

    public BasicShampoo(String name, BasicLabel label, ProductionBatch batch) {
        this.name = name;
        this.label = label;
        this.batch = batch;
        this.ingredients = new HashSet<>();
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

    public BasicLabel getLabel() {
        return label;
    }

    public void setLabel(BasicLabel label) {
        this.label = label;
    }

    public ProductionBatch getBatch() {
        return batch;
    }

    public void setBatch(ProductionBatch batch) {
        this.batch = batch;
    }

    public void setNames(List<String> names){
        this.names = names;
    }

    public void addIngredient(BasicIngredient ingredient){
        this.ingredients.add(ingredient);
    }

    public Set<BasicIngredient> getIngredients(){
        return Collections.unmodifiableSet(this.ingredients);
    }
}
