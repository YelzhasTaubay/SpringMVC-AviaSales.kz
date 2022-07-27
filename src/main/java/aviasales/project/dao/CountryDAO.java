package aviasales.project.dao;

import aviasales.project.entities.Countries;

public interface CountryDAO {

    void addCountry(Countries countries);

    void updateCountry(Countries countries);

    void deleteCountry(Countries countries);

    Countries getCountryById(Long id);

}
