package by.mk_jd2_92_22.pizzeria.dao.api;

import by.mk_jd2_92_22.pizzeria.dao.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IMenuDao extends JpaRepository<Menu, Long> {

    @Query("SELECT m FROM Menu m JOIN FETCH m.items")
    List<Menu> getListMenu();
}
