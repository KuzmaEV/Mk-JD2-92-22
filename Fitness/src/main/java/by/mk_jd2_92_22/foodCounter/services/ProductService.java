package by.mk_jd2_92_22.foodCounter.services;

import by.mk_jd2_92_22.foodCounter.core.builder.ProductBuilder;
import by.mk_jd2_92_22.foodCounter.dao.IProductDao;
import by.mk_jd2_92_22.foodCounter.dao.entity.Product;
import by.mk_jd2_92_22.foodCounter.services.api.IProductService;
import by.mk_jd2_92_22.foodCounter.services.dto.ProductDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class ProductService implements IProductService {

    private final IProductDao dao;

    public ProductService(IProductDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public Product create(ProductDTO item) {

        UUID uuid = UUID.randomUUID();
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);

        return dao.save(ProductBuilder.create()
                .setUuid(uuid)
                .setDtCreate(now)
                .setDtUpdate(now)
                .setName(item.getName())
                .setKcal(item.getKcal())
                .setProteins(item.getProteins())
                .setFats(item.getFats())
                .setCarbohydrates(item.getCarbohydrates())
                .setWeight(item.getWeight())
                .build());
    }

    @Override
    public Product get(UUID uuid) {
        return dao.findById(uuid).orElseThrow();
    }

    @Override
    public List<Product> getAll() {
        return dao.findAll();
    }

    @Override
    @Transactional
    public Product update(UUID uuid, LocalDateTime dtUpdate, ProductDTO item) {

        Product product = dao.findById(uuid).orElseThrow();
        if (product.getDtUpdate().isEqual(dtUpdate)){
            product.setDtUpdate(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS));
            product.setName(item.getName());
        }else {
            throw new IllegalArgumentException("Не удалось обнавить, было кем-то изменино раньше." +
                    " Попробуйте еще раз!");
        }

        return dao.save(product);
    }

    @Override
    @Transactional
    public void delete(UUID uuid, LocalDateTime dtUpdate) {

        Product product = dao.findById(uuid).orElseThrow();
        if (product.getDtUpdate().isEqual(dtUpdate)){
            dao.delete(product);
        }else {
            throw new IllegalArgumentException("Не удалось обнавить, было кемнто изменино раньше." +
                    " Попробуйте еще раз!");
        }

    }
}
