package aviasales.project.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "prices")
public class Prices {
    //prices (id, flight_id, econom_value, business_value, assigned_time)  //  7, 6, 50000, 90000, 2018-10-16 10:45

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Flights flight_id;

    private int econom_value;

    private int business_value;

    private Date assigned_time;

    public Prices() {
    }

    public Prices(Long id, Flights flight_id, int econom_value, int business_value, Date assigned_time) {
        this.id = id;
        this.flight_id = flight_id;
        this.econom_value = econom_value;
        this.business_value = business_value;
        this.assigned_time = assigned_time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Flights getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(Flights flight_id) {
        this.flight_id = flight_id;
    }

    public int getEconom_value() {
        return econom_value;
    }

    public void setEconom_value(int econom_value) {
        this.econom_value = econom_value;
    }

    public int getBusiness_value() {
        return business_value;
    }

    public void setBusiness_value(int business_value) {
        this.business_value = business_value;
    }

    public Date getAssigned_time() {
        return assigned_time;
    }

    public void setAssigned_time(Date assigned_time) {
        this.assigned_time = assigned_time;
    }
}
