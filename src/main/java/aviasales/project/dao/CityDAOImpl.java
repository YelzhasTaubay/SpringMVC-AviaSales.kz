package aviasales.project.dao;

import aviasales.project.entities.Aircrafts;
import aviasales.project.entities.Cities;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CityDAOImpl implements CityDAO{

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public void addCity(Cities city) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(city);
        transaction.commit();;
        session.close();
    }

    @Override
    public Cities getCityById(Long id) {
        Session session=sessionFactory.openSession();
        CriteriaBuilder builder=session.getCriteriaBuilder();
        CriteriaQuery<Cities> query=builder.createQuery(Cities.class);
        Root<Cities> root=query.from(Cities.class);
        Predicate predicate=builder.equal(root.get("id"),id);
        Cities city=session.createQuery(query.where(predicate)).uniqueResult();
        return city;
    }

    @Override
    public void updateCity(Cities city) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.update(city);
        transaction.commit();;
        session.close();
    }

    @Override
    public void deleteCity(Cities city) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.delete(city);
        transaction.commit();
        session.close();
    }
}
