package by.mk_jd2_92_22.foodCounter.dao;

import by.mk_jd2_92_22.foodCounter.dao.entity.JournalFood;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IJournalFoodDao extends JpaRepository<JournalFood, UUID> {
}
