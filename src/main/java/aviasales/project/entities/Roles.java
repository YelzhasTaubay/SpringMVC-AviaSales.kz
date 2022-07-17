package aviasales.project.entities;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Roles {
    //id, name


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;

    public Roles() {
    }
    public Roles(Long id, String role) {
        this.id = id;
        this.role=role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return role;
    }

    public void setName(String name) {
        this.role = name;
    }
}
