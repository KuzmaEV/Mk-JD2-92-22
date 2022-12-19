package by.mk_jd2_92_22.foodCounter.services;

import by.mk_jd2_92_22.foodCounter.dao.IFoodDiaryDao;
import by.mk_jd2_92_22.foodCounter.dao.entity.Dish;
import by.mk_jd2_92_22.foodCounter.dao.entity.FoodDiary;
import by.mk_jd2_92_22.foodCounter.dao.entity.Product;
import by.mk_jd2_92_22.foodCounter.services.api.IDishService;
import by.mk_jd2_92_22.foodCounter.services.api.IFoodDiaryService;
import by.mk_jd2_92_22.foodCounter.services.api.IProductService;
import by.mk_jd2_92_22.foodCounter.services.dto.FoodDiaryDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class FoodDiaryService implements IFoodDiaryService {

    private final IFoodDiaryDao dao;
    private final IProductService productService;
    private final IDishService dishService;

    public FoodDiaryService(IFoodDiaryDao dao, IProductService productService, IDishService dishService) {
        this.dao = dao;
        this.productService = productService;
        this.dishService = dishService;
    }

    @Override @Transactional
    public FoodDiary create(FoodDiaryDTO item) {

        UUID uuid = UUID.randomUUID();
        LocalDateTime time = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);

        Product product = null;
        Dish dish = null;

        if (item.getProduct() != null) {
            product = this.productService.get(item.getProduct());
        }

        if (item.getDish() != null) {
            dish = this.dishService.get(item.getDish());
        }

        FoodDiary diary = new FoodDiary(uuid,
                time,
                time,
                product,
                dish,
                item.getWeight());

        return this.dao.save(diary);
    }

    @Override
    public FoodDiary get(UUID uuid) {
        return null;
    }

    @Override
    public List<FoodDiary> getAll() {
        return null;
    }

    @Override @Transactional
    public FoodDiary update(UUID uuid, LocalDateTime dtUpdate, FoodDiaryDTO item) {
        return null;
    }

    @Override @Transactional
    public void delete(UUID uuid, LocalDateTime dtUpdate) {

    }
}
