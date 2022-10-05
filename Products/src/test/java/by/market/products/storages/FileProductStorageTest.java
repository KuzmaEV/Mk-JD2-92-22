package by.market.products.storages;

import by.market.products.storages.entity.Product;
import by.market.products.storages.entity.ProductBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FileProductStorageTest {
 //   @Test
    public void save(){

        System.out.println(System.getProperty("java.io.tmpdir"));
        FileProductStorage storage = new FileProductStorage(System.getProperty("java.io.tmpdir"));
        Product product = ProductBuilder.create()
                .setName("Хлебушек")
                .setPrice(1.5)
                .setSale(5)
                .setDescription("black")
                .build();

        storage.save(product);

        Assertions.assertNotNull(product.getId());

        Product byId = storage.getById(product.getId());

        Assertions.assertEquals("Хлебушек", byId.getName());
        Assertions.assertEquals(1.5, byId.getPrice());
        Assertions.assertEquals(5, byId.getSale());
        Assertions.assertEquals("black", byId.getDescription());

    }

  //  @Test

    public void get(){

        FileProductStorage storage = new FileProductStorage(System.getProperty("java.io.tmpdir"));
        List<Product> beforeSave = storage.get();

        Product product = ProductBuilder.create()
                .setName("Хлебушек")
                .setPrice(1.5)
                .setSale(5)
                .setDescription("black")
                .build();

        storage.save(product);

        Assertions.assertNotNull(storage.get());

        List<Product> afterSave = storage.get();

        Assertions.assertEquals(beforeSave.size() + 1, afterSave.size());



    }

}
