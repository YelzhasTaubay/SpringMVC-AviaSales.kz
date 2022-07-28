package aviasales.project.dao;

import aviasales.project.entities.Aircrafts;
import aviasales.project.entities.Tickets;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import sun.security.krb5.internal.Ticket;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class TicketsDAOImpl implements TicketsDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addTicket(Tickets ticket) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(ticket);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateTicket(Tickets ticket) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.update(ticket);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteTicket(Tickets ticket) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.delete(ticket);
        transaction.commit();;
        session.close();
    }

    @Override
    public Tickets getTicketById(Long id) {
        Session session=sessionFactory.openSession();
        CriteriaBuilder builder=session.getCriteriaBuilder();
        CriteriaQuery<Tickets> query=builder.createQuery(Tickets.class);
        Root<Tickets> root=query.from(Tickets.class);
        Predicate predicate=builder.equal(root.get("id"),id);
        Tickets ticket=session.createQuery(query.where(predicate)).uniqueResult();
        return ticket;
    }



}
