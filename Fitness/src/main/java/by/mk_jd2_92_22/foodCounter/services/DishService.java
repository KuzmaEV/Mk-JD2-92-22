package by.mk_jd2_92_22.foodCounter.services;

import by.mk_jd2_92_22.foodCounter.dao.IDishDao;
import by.mk_jd2_92_22.foodCounter.dao.entity.Dish;
import by.mk_jd2_92_22.foodCounter.dao.entity.Ingredient;
import by.mk_jd2_92_22.foodCounter.services.api.IDishService;
import by.mk_jd2_92_22.foodCounter.services.api.IIngredientService;
import by.mk_jd2_92_22.foodCounter.services.dto.DishDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class DishService implements IDishService {

    private final IDishDao dao;
    private final IIngredientService ingredientService;

    public DishService(IDishDao dao, IIngredientService ingredientService) {
        this.dao = dao;
        this.ingredientService = ingredientService;
    }

    @Override
    @Transactional
    public Dish create(DishDTO item) {

        UUID uuidDish = UUID.randomUUID();

        LocalDateTime time = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);

        List<Ingredient> ingredients = ingredientService.create(item.getIngredients());

//        List<Ingredient> ingredients = item.getIngredients().stream().map(i ->
//                        new Ingredient(UUID.randomUUID(), this.productService.get(i.getProduct()),
//                                i.getWeight()))
//                .collect(Collectors.toList());


        Dish dish = new Dish(uuidDish,
                time,
                time,
                item.getName(),
                ingredients);

        return dao.save(dish);
    }

    @Override
    public Dish get(UUID uuid) {



        return dao.findById(uuid).orElseThrow();
    }

    @Override
    public List<Dish> getAll() {
        return null;
    }

    @Override
    @Transactional
    public Dish update(UUID uuid, LocalDateTime dtUpdate, DishDTO item) {
        return null;
    }

    @Override
    @Transactional
    public void delete(UUID uuid, LocalDateTime dtUpdate) {

    }
}
