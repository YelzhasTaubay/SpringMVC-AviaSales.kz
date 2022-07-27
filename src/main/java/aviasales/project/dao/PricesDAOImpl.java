package aviasales.project.dao;

import aviasales.project.entities.Aircrafts;
import aviasales.project.entities.Prices;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class PricesDAOImpl implements PricesDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addPrice(Prices prices) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(prices);
        transaction.commit();
        session.close();
    }

    @Override
    public Prices getPriceById(Long id) {
        Session session=sessionFactory.openSession();
        CriteriaBuilder builder=session.getCriteriaBuilder();
        CriteriaQuery<Prices> query=builder.createQuery(Prices.class);
        Root<Prices> root=query.from(Prices.class);
        Predicate predicate=builder.equal(root.get("id"),id);
        Prices prices=session.createQuery(query.where(predicate)).uniqueResult();
        return prices;
    }

    @Override
    public void updatePrice(Prices prices) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.update(prices);
        transaction.commit();
        session.close();
    }

    @Override
    public void deletePrice(Prices prices) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.delete(prices);
        transaction.commit();
        session.close();
    }
}
