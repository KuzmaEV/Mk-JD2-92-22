package by.example.demo.pizzeria.dao.api;

import by.example.demo.pizzeria.dao.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ITicketDao extends JpaRepository<Ticket, Long> {

    @Modifying
    @Query(nativeQuery = true, value = "TRUNCATE TABLE pizzeria.ticket RESTART IDENTITY;")
    void resetTicket();
}
