package by.market.products.storages;

import by.market.products.storages.api.IStorageFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.SetEnvironmentVariable;

public class StorageFactoryTest {
 //   @Test
//    @SetEnvironmentVariable(key = "CATALINA_HOME", value = "C://")
    public void productStorageSingleton(){

        IStorageFactory instance1 = StorageFactory.getInstance();
        IStorageFactory instance2 = StorageFactory.getInstance();

        Assertions.assertEquals(instance1, instance2);

    }


}
