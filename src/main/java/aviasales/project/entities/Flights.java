package aviasales.project.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "flights")
public class Flights {
    //flights (id, route_id, departure_time, aircraft_id)  //  6, 5, 2018-10-17 10:00, 1

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Routes route_id;

    private Date departure_time;

    @ManyToOne(fetch = FetchType.EAGER)
    private Aircrafts aircraft_id;

    public Flights() {
    }
    public Flights(Long id, Routes route_id, Date departure_time, Aircrafts aircraft_id) {
        this.id = id;
        this.route_id = route_id;
        this.departure_time = departure_time;
        this.aircraft_id = aircraft_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Routes getRoute_id() {
        return route_id;
    }

    public void setRoute_id(Routes route_id) {
        this.route_id = route_id;
    }

    public Date getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(Date departure_time) {
        this.departure_time = departure_time;
    }

    public Aircrafts getAircraft_id() {
        return aircraft_id;
    }

    public void setAircraft_id(Aircrafts aircraft_id) {
        this.aircraft_id = aircraft_id;
    }
}
