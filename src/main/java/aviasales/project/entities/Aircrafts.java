package aviasales.project.entities;

import javax.persistence.*;

@Entity
@Table(name = "aircrafts")
public class Aircrafts {
    //id, name, model, ecenom_capacity, business_capacity

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int model;

    private int econom_capacity;

    private int business_capacity;


    public Aircrafts() {
    }
    public Aircrafts(Long id, String name, int model, int econom_capacity, int business_capacity) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.econom_capacity = econom_capacity;
        this.business_capacity = business_capacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public int getEconom_capacity() {
        return econom_capacity;
    }

    public void setEconom_capacity(int econom_capacity) {
        this.econom_capacity = econom_capacity;
    }

    public int getBusiness_capacity() {
        return business_capacity;
    }

    public void setBusiness_capacity(int business_capacity) {
        this.business_capacity = business_capacity;
    }
}
