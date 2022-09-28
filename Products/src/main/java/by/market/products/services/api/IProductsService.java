package by.market.products.services.api;

import by.market.products.core.DTO.ProductCreateDTO;
import by.market.products.storages.entity.Product;
import by.market.products.storages.entity.ProductBuilder;

import java.util.List;

public interface IProductsService {

    Product getById(Long id);

    List<Product> get();

    void validate(ProductCreateDTO item);

}
