package by.example.demo.pizzeria.dao.api;

import by.example.demo.pizzeria.dao.entity.Stage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStageDao extends JpaRepository<Stage, Long> {
}
