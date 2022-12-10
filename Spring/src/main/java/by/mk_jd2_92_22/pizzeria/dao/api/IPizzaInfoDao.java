package by.mk_jd2_92_22.pizzeria.dao.api;

import by.mk_jd2_92_22.pizzeria.dao.entity.PizzaInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPizzaInfoDao extends JpaRepository<PizzaInfo, Long> {
}
