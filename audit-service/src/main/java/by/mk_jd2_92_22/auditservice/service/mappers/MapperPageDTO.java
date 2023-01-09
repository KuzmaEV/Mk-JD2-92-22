package by.mk_jd2_92_22.auditservice.service.mappers;

import by.mk_jd2_92_22.auditservice.dto.PageDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class MapperPageDTO<T> {

    public PageDTO<T> mapper(Page<T> page){

        return new PageDTO<>(
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
