package aviasales.project.dao;

import aviasales.project.entities.Aircrafts;

public interface AircraftsDAO {

    void addAircraft(Aircrafts aircraft);

    Aircrafts getAircraftById(Long id);

    void updateAircraft(Aircrafts aircraft);

    void deleteAircraft(Aircrafts aircraft);



}
