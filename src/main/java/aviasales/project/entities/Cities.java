package aviasales.project.entities;

import javax.persistence.*;

@Entity
@Table(name = "cities")
public class Cities {
    //cities (id, country_id, name, shor_name)  // 3, 2, Almaty, ALA;  4, 2, Astana, TSE

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Countries countries_id;

    private String name;

    private String short_name;

    public Cities() {
    }
    public Cities(Long id, Countries countries_id, String name, String short_name) {
        this.id = id;
        this.countries_id = countries_id;
        this.name = name;
        this.short_name = short_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Countries getCountries_id() {
        return countries_id;
    }

    public void setCountries_id(Countries countries_id) {
        this.countries_id = countries_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }
}
