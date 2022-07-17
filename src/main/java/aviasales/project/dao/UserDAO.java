package aviasales.project.dao;

import aviasales.project.entities.Users;

import java.util.List;

public interface UserDAO {

    Users getUser(String email);

    List<Users> getUserByFullName(String fullname);

    void addUser(Users user);

    void deleteUser(Users user);

    void updateUser(Users user);

    List<Users> getAllUsers();

    Users getUserById(Long id);


}
