package by.mk_jd2_92_22.foodCounter.services.api;

import by.mk_jd2_92_22.foodCounter.dao.entity.Ingredient;
import by.mk_jd2_92_22.foodCounter.services.dto.IngredientDTO;

import java.util.List;

public interface IIngredientService extends IService<List<Ingredient>, List<IngredientDTO>> {
}
