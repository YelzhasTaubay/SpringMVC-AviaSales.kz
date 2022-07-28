package aviasales.project.dao;

import aviasales.project.entities.Tickets;

public interface TicketsDAO {

    void addTicket(Tickets ticket);

    void updateTicket(Tickets ticket);

    void deleteTicket(Tickets ticket);

    Tickets getTicketById(Long id);

}
