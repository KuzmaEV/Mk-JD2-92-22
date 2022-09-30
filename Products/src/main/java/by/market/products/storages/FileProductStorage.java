package by.market.products.storages;

import by.market.products.storages.api.IProductsStorage;
import by.market.products.storages.entity.Product;

import java.util.List;

public class FileProductStorage implements IProductsStorage {



    @Override
    public List<Product> get() {
        return null;
    }

    @Override
    public Product getById(Long id) {
        return null;
    }

    @Override
    public void save(Product item) {

    }
}
