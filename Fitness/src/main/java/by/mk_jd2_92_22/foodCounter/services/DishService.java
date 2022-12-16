package by.mk_jd2_92_22.foodCounter.services;

import by.mk_jd2_92_22.foodCounter.dao.entity.Dish;
import by.mk_jd2_92_22.foodCounter.services.api.IDishService;
import by.mk_jd2_92_22.foodCounter.services.dto.DishDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class DishService implements IDishService {
    @Override
    public Dish create(DishDTO item) {
        return null;
    }

    @Override
    public Dish read(UUID id) {
        return null;
    }

    @Override
    public List<Dish> get() {
        return null;
    }

    @Override
    public Dish update(UUID id, LocalDateTime dtUpdate, DishDTO item) {
        return null;
    }

    @Override
    public void delete(UUID id, LocalDateTime dtUpdate) {

    }
}
