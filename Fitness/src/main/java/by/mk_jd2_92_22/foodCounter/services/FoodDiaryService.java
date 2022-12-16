package by.mk_jd2_92_22.foodCounter.services;

import by.mk_jd2_92_22.foodCounter.dao.entity.FoodDiary;
import by.mk_jd2_92_22.foodCounter.services.api.IFoodDiaryService;
import by.mk_jd2_92_22.foodCounter.services.dto.FoodDiaryDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class FoodDiaryService implements IFoodDiaryService {
    @Override
    public FoodDiary create(FoodDiaryDTO item) {
        return null;
    }

    @Override
    public FoodDiary read(UUID id) {
        return null;
    }

    @Override
    public List<FoodDiary> get() {
        return null;
    }

    @Override
    public FoodDiary update(UUID id, LocalDateTime dtUpdate, FoodDiaryDTO item) {
        return null;
    }

    @Override
    public void delete(UUID id, LocalDateTime dtUpdate) {

    }
}
