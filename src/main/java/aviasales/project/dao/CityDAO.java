package aviasales.project.dao;

import aviasales.project.entities.Cities;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public interface CityDAO {

    void addCity(Cities city);

    Cities getCityById(Long id);

    void updateCity(Cities city);

    void deleteCity(Cities city);


}
