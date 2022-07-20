package aviasales.project.entities;

import javax.persistence.*;

@Entity
@Table(name = "routes")
public class Routes {
    //routes (id, name, departure_city_id, arrival_city_id)  // 5, ALMATY-ASTANA, 3, 4

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    private Cities departure_city_id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Cities arrival_city_id;

    public Routes() {
    }
    public Routes(Long id, String name, Cities departure_city_id, Cities arrival_city_id) {
        this.id = id;
        this.name = name;
        this.departure_city_id = departure_city_id;
        this.arrival_city_id = arrival_city_id;
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

    public Cities getDeparture_city_id() {
        return departure_city_id;
    }

    public void setDeparture_city_id(Cities departure_city_id) {
        this.departure_city_id = departure_city_id;
    }

    public Cities getArrival_city_id() {
        return arrival_city_id;
    }

    public void setArrival_city_id(Cities arrival_city_id) {
        this.arrival_city_id = arrival_city_id;
    }
}
