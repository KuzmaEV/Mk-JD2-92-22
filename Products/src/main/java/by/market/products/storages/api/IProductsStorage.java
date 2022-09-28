package by.market.products.storages.api;

import by.market.products.storages.entity.Product;

import java.util.List;

public interface IProductsStorage {
    List <Product> get();
    Product getById(Long id);
    void save(Product item);
}
