package by.example.demo.pizzeria.dao.api;

import by.example.demo.pizzeria.dao.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface IOrderStatusDao extends JpaRepository<OrderStatus, Long> {

    OrderStatus findByTicket(Long ticket);

    @Modifying
    @Query("delete Stage s where s.orderStatus = ?1")
    void deleteStageFromOrderStatus(long id);
}
