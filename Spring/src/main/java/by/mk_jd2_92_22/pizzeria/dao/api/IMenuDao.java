package by.mk_jd2_92_22.pizzeria.dao.api;

import by.mk_jd2_92_22.pizzeria.dao.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMenuDao extends JpaRepository<Menu, Long> {
}
