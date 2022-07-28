package aviasales.project.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tickets")
public class Tickets {
    //tickets (id, user_id, flight_id, name, surname, passport_no, price, is_business, booked_time)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Users user_id;

    @ManyToOne(fetch=FetchType.EAGER)
    private Flights flight_id;

    private String name;

    private String surname;

    private int password_no;

    private int price;

    private String is_business;

    private Date booked_time;

    public Tickets() {
    }

    public Tickets(Long id, Users user_id, Flights flight_id, String name, String surname, int password_no, int price, String is_business, Date booked_time) {
        this.id = id;
        this.user_id = user_id;
        this.flight_id = flight_id;
        this.name = name;
        this.surname = surname;
        this.password_no = password_no;
        this.price = price;
        this.is_business = is_business;
        this.booked_time = booked_time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUser_id() {
        return user_id;
    }

    public void setUser_id(Users user_id) {
        this.user_id = user_id;
    }

    public Flights getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(Flights flight_id) {
        this.flight_id = flight_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPassword_no() {
        return password_no;
    }

    public void setPassword_no(int password_no) {
        this.password_no = password_no;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getIs_business() {
        return is_business;
    }

    public void setIs_business(String is_business) {
        this.is_business = is_business;
    }

    public Date getBooked_time() {
        return booked_time;
    }

    public void setBooked_time(Date booked_time) {
        this.booked_time = booked_time;
    }
}
