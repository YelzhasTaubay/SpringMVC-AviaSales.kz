package aviasales.project.dao;

import aviasales.project.entities.Aircrafts;
import aviasales.project.entities.Routes;

public interface RoutesDAO {

    void addRoute(Routes aircraft);

    Routes getRouteById(Long id);

    void updateRoute(Routes aircraft);

    void deleteRoute(Routes aircraft);
}
