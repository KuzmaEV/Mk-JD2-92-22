package by.mk_jd2_92_22.foodCounter.services;

import by.mk_jd2_92_22.foodCounter.dao.entity.Product;
import by.mk_jd2_92_22.foodCounter.services.api.IProductService;
import by.mk_jd2_92_22.foodCounter.services.dto.ProductDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class ProductService implements IProductService {

    @Override
    public Product create(ProductDTO item) {
        return null;
    }

    @Override
    public Product read(UUID id) {
        return null;
    }

    @Override
    public List<Product> get() {
        return null;
    }

    @Override
    public Product update(UUID id, LocalDateTime dtUpdate, ProductDTO item) {
        return null;
    }

    @Override
    public void delete(UUID id, LocalDateTime dtUpdate) {

    }
}
