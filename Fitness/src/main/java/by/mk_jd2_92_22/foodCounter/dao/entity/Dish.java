package by.mk_jd2_92_22.foodCounter.dao.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Dish {

    private UUID uuid;
    private LocalDateTime dtCreate;
    private LocalDateTime dtUpdate;

    private String name;
    private List<Ingredient> ingredients;
}
