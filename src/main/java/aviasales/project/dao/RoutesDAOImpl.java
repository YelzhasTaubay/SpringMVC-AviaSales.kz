package aviasales.project.dao;

import aviasales.project.entities.Aircrafts;
import aviasales.project.entities.Routes;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class RoutesDAOImpl implements RoutesDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addRoute(Routes routes) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(routes);
        transaction.commit();
        session.close();
    }

    @Override
    public Routes getRouteById(Long id) {
        Session session=sessionFactory.openSession();
        CriteriaBuilder builder=session.getCriteriaBuilder();
        CriteriaQuery<Routes> query=builder.createQuery(Routes.class);
        Root<Routes> root=query.from(Routes.class);
        Predicate predicate=builder.equal(root.get("id"),id);
        Routes routes=session.createQuery(query.where(predicate)).uniqueResult();
        return routes;
    }

    @Override
    public void updateRoute(Routes routes) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.update(routes);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteRoute(Routes routes) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.delete(routes);
        transaction.commit();
        session.close();
    }
}
