package by.mk_jd2_92_22.foodCounter.services.api;


import by.mk_jd2_92_22.foodCounter.dao.entity.Ingredient;
import by.mk_jd2_92_22.foodCounter.services.dto.IngredientDTO;

import java.util.List;
import java.util.UUID;

public interface IIngredientService {
    List<Ingredient> create(List<IngredientDTO> items);
    void delete(List<UUID> items);
}
