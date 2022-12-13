package by.example.demo.pizzeria.dao.api;


import by.example.demo.pizzeria.dao.entity.MenuRow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMenuRowDao extends JpaRepository<MenuRow, Long> {
}
