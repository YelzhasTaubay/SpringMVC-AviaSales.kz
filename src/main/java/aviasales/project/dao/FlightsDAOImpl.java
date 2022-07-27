package aviasales.project.dao;

import aviasales.project.entities.Aircrafts;
import aviasales.project.entities.Flights;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class FlightsDAOImpl implements FlightDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addFlight(Flights flights) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(flights);
        transaction.commit();
        session.close();
    }

    @Override
    public Flights getFlightById(Long id) {
        Session session=sessionFactory.openSession();
        CriteriaBuilder builder=session.getCriteriaBuilder();
        CriteriaQuery<Flights> query=builder.createQuery(Flights.class);
        Root<Flights> root=query.from(Flights.class);
        Predicate predicate=builder.equal(root.get("id"),id);
        Flights flights=session.createQuery(query.where(predicate)).uniqueResult();
        return flights;
    }

    @Override
    public void updateFlight(Flights flights) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.update(flights);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteFlight(Flights flights) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.delete(flights);
        transaction.commit();
        session.close();
    }
}
