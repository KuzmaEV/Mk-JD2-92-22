package by.mk_jd2_92_22.foodCounter.services;

import by.mk_jd2_92_22.foodCounter.core.exception.RecipeNotFoundException;
import by.mk_jd2_92_22.foodCounter.dao.IRecipeDao;
import by.mk_jd2_92_22.foodCounter.dao.entity.Recipe;
import by.mk_jd2_92_22.foodCounter.dao.entity.Ingredient;
import by.mk_jd2_92_22.foodCounter.services.api.IRecipeService;
import by.mk_jd2_92_22.foodCounter.services.api.IIngredientService;
import by.mk_jd2_92_22.foodCounter.services.dto.RecipeDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class RecipeService implements IRecipeService {

    private final IRecipeDao dao;
    private final IIngredientService ingredientService;

    public RecipeService(IRecipeDao dao, IIngredientService ingredientService) {
        this.dao = dao;
        this.ingredientService = ingredientService;
    }

    @Override
    @Transactional
    public Recipe create(RecipeDTO item) {

        UUID uuidDish = UUID.randomUUID();

        LocalDateTime time = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);

        List<Ingredient> ingredients = ingredientService.create(item.getIngredients());

        Recipe dish = new Recipe(uuidDish,
                time,
                time,
                item.getTitle(),
                ingredients);

        return dao.save(dish);
    }

    @Override
    public Recipe get(UUID uuid) {

        return dao.findById(uuid).orElseThrow(()-> new RecipeNotFoundException(uuid));
    }

    @Override
    public List<Recipe> getAll() {
        return dao.findAll();
    }

    @Override
    @Transactional
    public Recipe update(UUID uuid, LocalDateTime dtUpdate, RecipeDTO item) {

        Recipe dish = this.dao.findById(uuid).orElseThrow(()-> new RecipeNotFoundException(uuid));

        if (dish.getDtUpdate().isEqual(dtUpdate)){

            List<Ingredient> ingredients = this.ingredientService.create(item.getIngredients());

            dish.setDtUpdate(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS));
            dish.setTitle(item.getTitle());
            dish.setIngredients(ingredients);
        }else {
            throw new IllegalArgumentException("Не удалось обнавить, было кем-то изменино раньше." +
                    " Попробуйте еще раз!");
        }
        return this.dao.save(dish);
    }

    @Override
    @Transactional
    public void delete(UUID uuid, LocalDateTime dtUpdate) {

        Recipe dish = dao.findById(uuid).orElseThrow(()-> new RecipeNotFoundException(uuid));
        if (dish.getDtUpdate().isEqual(dtUpdate)){
            dao.delete(dish);
        }else {
            throw new IllegalArgumentException("Не удалось обнавить, было кемнто изменино раньше." +
                    " Попробуйте еще раз!");
        }
    }
}