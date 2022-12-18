package by.mk_jd2_92_22.foodCounter.services;

import by.mk_jd2_92_22.foodCounter.services.api.IIngredientService;
import by.mk_jd2_92_22.foodCounter.services.dto.IngredientDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class IngredientService implements IIngredientService {
    @Override
    public Integer create(IngredientDTO item) {
        return null;
    }

    @Override
    public Integer get(UUID uuid) {
        return null;
    }

    @Override
    public List<Integer> getAll() {
        return null;
    }

    @Override
    public Integer update(UUID uuid, LocalDateTime dtUpdate, IngredientDTO item) {
        return null;
    }

    @Override
    public void delete(UUID uuid, LocalDateTime dtUpdate) {

    }
}
