package by.example.demo.pizzeria.dao.api;

import by.example.demo.pizzeria.dao.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderDao extends JpaRepository<Order, Long> {
}
