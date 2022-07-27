package aviasales.project.dao;

import aviasales.project.entities.Aircrafts;
import aviasales.project.entities.Prices;

public interface PricesDAO {

    void addPrice(Prices prices);

    Prices getPriceById(Long id);

    void updatePrice(Prices prices);

    void deletePrice(Prices prices);

}
