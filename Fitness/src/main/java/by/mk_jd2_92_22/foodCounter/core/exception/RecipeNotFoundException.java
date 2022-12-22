package by.mk_jd2_92_22.foodCounter.core.exception;

import java.util.UUID;

public class RecipeNotFoundException extends RuntimeException{

    public RecipeNotFoundException(UUID uuid)
    {
        super("Не удалось найти блюдо " + uuid);
    }
}
