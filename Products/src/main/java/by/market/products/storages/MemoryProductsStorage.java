package by.market.products.storages;

import by.market.products.storages.entity.Product;
import by.market.products.storages.entity.ProductBuilder;
import by.market.products.storages.api.IProductsStorage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryProductsStorage implements IProductsStorage {

//    private static final ProductsStorage instance = new ProductsStorage();
//    List<Product> data = new ArrayList<>();
    Map<Long, Product> data = new HashMap<>();



     MemoryProductsStorage() {
         Product p = (ProductBuilder.create()
                 .setId((long)this.data.size())
                 .setName("Молоко")
                 .setPrice(1.40)
                 .setDescription("Коровье 3.2%")
                 .build());
        this.data.put(p.getId(), p);
    }

//    public static ProductsStorage getInstance(){
//        return instance;
//    }

    @Override
    public List<Product> get() {
         return new ArrayList<>(this.data.values());
    }


    @Override
    public Product getById(Long id) {
        return this.data.get(id);
    }

    @Override
    public void save(Product item) {
       if (item.getId() != null){
           throw new IllegalStateException("ID должен быть пустым!");
       }

       item.setId((long)this.data.size());

       this.data.put(item.getId(), item);

    }
}
