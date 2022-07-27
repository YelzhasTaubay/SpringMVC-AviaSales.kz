package aviasales.project.dao;

import aviasales.project.entities.Aircrafts;
import aviasales.project.entities.Flights;

public interface FlightDAO {

    void addFlight(Flights flights);

    Flights getFlightById(Long id);

    void updateFlight(Flights flights);

    void deleteFlight(Flights flights);

}
