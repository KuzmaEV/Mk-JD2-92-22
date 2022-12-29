package by.mk_jd2_92_22.foodCounter.services;

import by.mk_jd2_92_22.foodCounter.core.exception.JournalFoodNotFoundException;
import by.mk_jd2_92_22.foodCounter.dao.IJournalFoodDao;
import by.mk_jd2_92_22.foodCounter.dao.entity.Recipe;
import by.mk_jd2_92_22.foodCounter.dao.entity.JournalFood;
import by.mk_jd2_92_22.foodCounter.dao.entity.Product;
import by.mk_jd2_92_22.foodCounter.services.api.IRecipeService;
import by.mk_jd2_92_22.foodCounter.services.api.IJournalFoodService;
import by.mk_jd2_92_22.foodCounter.services.api.IProductService;
import by.mk_jd2_92_22.foodCounter.services.dto.JournalFoodDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class JournalFoodService implements IJournalFoodService {

    private final IJournalFoodDao dao;
    private final IProductService productService;
    private final IRecipeService dishService;

    public JournalFoodService(IJournalFoodDao dao, IProductService productService, IRecipeService dishService) {
        this.dao = dao;
        this.productService = productService;
        this.dishService = dishService;
    }

    @Override @Transactional
    public JournalFood create(JournalFoodDTO item) {

        UUID uuid = UUID.randomUUID();
        LocalDateTime time = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);

        Product product = null;
        Recipe dish = null;

        if (item.getProduct() != null) {
            product = this.productService.get(item.getProduct().getUuid());
        } else if (item.getDish() != null) {
            dish = this.dishService.get(item.getDish().getUuid());
        } else {throw new IllegalStateException("Запрос некорректен. Сервер не может обработать запрос");}

        JournalFood diary = new JournalFood(uuid,
                time,
                time,
                item.getDtSupply(),
                product,
                dish,
                item.getWeight());

        return this.dao.save(diary);
    }

    @Override
    public JournalFood get(UUID uuid) {
        return  this.dao.findById(uuid).orElseThrow(()-> new JournalFoodNotFoundException(uuid));
    }

    @Override
    public List<JournalFood> getAll() {

        return this.dao.findAll();
    }

    @Override @Transactional
    public JournalFood update(UUID uuid, LocalDateTime dtUpdate, JournalFoodDTO item) {

        JournalFood diary = dao.findById(uuid).orElseThrow(()-> new JournalFoodNotFoundException(uuid));

        if (diary.getDtUpdate().isEqual(dtUpdate)){

            Product product = null;
            Recipe dish = null;

            if (item.getProduct() != null) {
                product = this.productService.get(item.getProduct().getUuid());
            }
            if (item.getDish() != null) {
                dish = this.dishService.get(item.getDish().getUuid());
            }

            diary.setDtUpdate(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS));
            diary.setProduct(product);
            diary.setDish(dish);
            diary.setWeight(item.getWeight());

        }else {
            throw new IllegalArgumentException("Не удалось обнавить, было кем-то изменино раньше." +
                    " Попробуйте еще раз!");
        }
        return this.dao.save(diary);
    }

    @Override @Transactional
    public void delete(UUID uuid, LocalDateTime dtUpdate) {

        JournalFood diary = dao.findById(uuid).orElseThrow(()-> new JournalFoodNotFoundException(uuid));

        if (diary.getDtUpdate().isEqual(dtUpdate)){
            dao.delete(diary);
        }else {
            throw new IllegalArgumentException("Не удалось обнавить, было кемнто изменино раньше." +
                    " Попробуйте еще раз!");
        }

    }
}