package by.mk_jd2_92_22.foodCounter.core.exception;

import java.util.UUID;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(UUID uuid)
    {
        super("Не удалось найти продукт " + uuid);
    }
}
