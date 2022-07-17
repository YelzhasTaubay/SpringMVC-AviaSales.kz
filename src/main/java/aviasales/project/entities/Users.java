package aviasales.project.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class Users {
    //id, login, password, full_name

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String fullname;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Roles> roles;

    public Users() {
    }
    public Users(Long id, String email, String password, String fullname) {
        this.id = id;
        this.email=email;
        this.password = password;
        this.fullname = fullname;
    }
    public Users(Long id, String email, String password, String full_name,Set<Roles> roles) {
        this.id = id;
        this.email=email;
        this.password = password;
        this.fullname = fullname;
        this.roles=roles;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public Set<Roles> getRoles() {
        return roles;
    }


}
