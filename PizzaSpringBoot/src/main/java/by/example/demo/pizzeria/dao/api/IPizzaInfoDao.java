package by.example.demo.pizzeria.dao.api;

import by.example.demo.pizzeria.dao.entity.PizzaInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPizzaInfoDao extends JpaRepository<PizzaInfo, Long> {
}
