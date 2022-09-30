package by.market.products.services;

import by.market.products.core.DTO.ProductCreateDTO;
import by.market.products.storages.StorageFactory;
import by.market.products.storages.entity.Product;
import by.market.products.services.api.IProductsService;
import by.market.products.storages.api.IProductsStorage;
import by.market.products.storages.entity.ProductBuilder;

import java.util.List;

public class ProductsService implements IProductsService {


    private final IProductsStorage storage;

    private static final ProductsService instance = new ProductsService();

    public ProductsService() {
        this.storage = StorageFactory.getInstance().getProductStorage();
    }

    @Override
    public Product getById(Long id) {
        return this.storage.getById(id);
    }

    @Override
    public List<Product> get() {
        return this.storage.get();
    }

    @Override
    public void validate(ProductCreateDTO item) {
        storage.save(ProductBuilder.create()
                .setId(null)
                .setDescription(item.getDescription())
                .setPrice(item.getPrice())
                .setName(item.getName())
                .setSale(item.getSale())
                .build());

    }

    public static ProductsService getInstance(){
        return instance;
    }
}
