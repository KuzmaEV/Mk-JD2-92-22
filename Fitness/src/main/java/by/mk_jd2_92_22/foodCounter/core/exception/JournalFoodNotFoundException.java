package by.mk_jd2_92_22.foodCounter.core.exception;

import java.util.UUID;

public class JournalFoodNotFoundException extends RuntimeException{

    public JournalFoodNotFoundException(UUID uuid)
    {
        super("Не удалось найти запись дневника питания " + uuid);
    }
}
