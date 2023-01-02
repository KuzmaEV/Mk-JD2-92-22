package by.mk_jd2_92_22.foodCounter.services.mappers;

import by.mk_jd2_92_22.foodCounter.services.dto.IPageDTO;
import org.springframework.data.domain.Page;

public interface IMapperPageDTO<T> {
    IPageDTO<T> mapper(Page<T> page);
}
