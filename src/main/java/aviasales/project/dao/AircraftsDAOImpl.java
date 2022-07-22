package aviasales.project.dao;

import aviasales.project.entities.Aircrafts;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class AircraftsDAOImpl implements AircraftsDAO{


    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addAircraft(Aircrafts aircraft) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(aircraft);
        transaction.commit();
        session.close();
    }

}
