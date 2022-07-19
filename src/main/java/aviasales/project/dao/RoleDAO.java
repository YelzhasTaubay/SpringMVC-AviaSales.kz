package aviasales.project.dao;

import aviasales.project.entities.Roles;

import java.util.List;

public interface RoleDAO {

    Roles getRole(String role);

    List<Roles> getAllRoles();

    void addRoles(Roles roles);

}
