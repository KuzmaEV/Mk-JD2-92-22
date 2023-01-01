package by.mk_jd2_92_22.foodCounter.services.mappers;

import by.mk_jd2_92_22.foodCounter.services.dto.PageDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class MapperPageDTO {

    public PageDTO mapper(Page page){

        return new PageDTO(
                page.getNumber(),
                page.getSize(),
                page.getTotalPages(),
                (int)page.getTotalElements(),
                page.isFirst(),
                page.getNumberOfElements(),
                page.isLast(),
                page.getContent());
    }
}
