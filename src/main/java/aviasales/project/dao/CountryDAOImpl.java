package aviasales.project.dao;

import aviasales.project.entities.Aircrafts;
import aviasales.project.entities.Cities;
import aviasales.project.entities.Countries;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CountryDAOImpl implements CountryDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addCountry(Countries countries) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(countries);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateCountry(Countries countries) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.update(countries);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteCountry(Countries countries) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.delete(countries);
        transaction.commit();
        session.close();
    }

    @Override
    public Countries getCountryById(Long id) {
        Session session=sessionFactory.openSession();
        CriteriaBuilder builder=session.getCriteriaBuilder();
        CriteriaQuery<Countries> query=builder.createQuery(Countries.class);
        Root<Countries> root=query.from(Countries.class);
        Predicate predicate=builder.equal(root.get("id"),id);
        Countries countries=session.createQuery(query.where(predicate)).uniqueResult();
        return countries;
    }


}
