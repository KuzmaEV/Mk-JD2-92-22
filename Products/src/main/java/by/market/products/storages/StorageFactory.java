package by.market.products.storages;

import by.market.products.storages.api.IProductsStorage;
import by.market.products.storages.api.IStorageFactory;

public class StorageFactory implements IStorageFactory {

    private static final IStorageFactory instance = new StorageFactory();

    private IProductsStorage productsStorage;

    public StorageFactory() {
        this.productsStorage = new ProductsStorage();
    }

    @Override
    public IProductsStorage getProductStorage() {
        return this.productsStorage;
    }

    public static IStorageFactory getInstance() {
        return instance;
    }
}
