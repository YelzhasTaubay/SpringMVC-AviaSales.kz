package aviasales.project.dao;

import aviasales.project.entities.Aircrafts;
import aviasales.project.entities.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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

    @Override
    public Aircrafts getAircraftById(Long id) {
        Session session=sessionFactory.openSession();
        CriteriaBuilder builder=session.getCriteriaBuilder();
        CriteriaQuery<Aircrafts> query=builder.createQuery(Aircrafts.class);
        Root<Aircrafts> root=query.from(Aircrafts.class);
        Predicate predicate=builder.equal(root.get("id"),id);
        Aircrafts aircraft=session.createQuery(query.where(predicate)).uniqueResult();
        return aircraft;
    }

//    public Users getUserById(Long id){
//        Session session=sessionFactory.openSession();
//        CriteriaBuilder builder=session.getCriteriaBuilder();
//        CriteriaQuery<Users> query=builder.createQuery(Users.class);
//        Root<Users> root=query.from(Users.class);
//        Predicate predicate=builder.equal(root.get("id"),id);
//        Users user=session.createQuery(query.where(predicate)).uniqueResult();
//        session.close();
//        return user;

}
