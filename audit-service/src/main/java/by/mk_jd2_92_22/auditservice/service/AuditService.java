package by.mk_jd2_92_22.auditservice.service;

import by.mk_jd2_92_22.auditservice.exception.NotFoundException;
import by.mk_jd2_92_22.auditservice.dto.AuditRequestDTO;
import by.mk_jd2_92_22.auditservice.dto.PageDTO;
import by.mk_jd2_92_22.auditservice.repository.AuditRepository;
import by.mk_jd2_92_22.auditservice.model.Audit;
import by.mk_jd2_92_22.auditservice.service.api.IAuditService;
import by.mk_jd2_92_22.auditservice.service.mappers.MapperPageDTO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public class AuditService implements IAuditService {

   private final AuditRepository dao;
   private final MapperPageDTO<Audit> mapperPage;

    public AuditService(AuditRepository dao, MapperPageDTO<Audit> mapperPage) {
        this.dao = dao;
        this.mapperPage = mapperPage;
    }

    @Override
    public PageDTO<Audit> get(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        return mapperPage.mapper(dao.findAll(pageable));
    }

    @Override
    public Audit get(String id) {

//        RestTemplate restTemplate = new RestTemplate();
//        MyUserDTO userDTO = restTemplate
//                .getForEntity("http://user-service:8080/api/v1/users/" + audit.getUser(), MyUserDTO.class)
//                .getBody();

        return dao.findById(id).orElseThrow(() ->
                new NotFoundException("Аудит с таким id не найден"));
    }

    @Override
    @Transactional
    public Audit create(AuditRequestDTO dto) {

        Audit audit = new Audit();
        audit.setUser(dto.getUser());
        audit.setText(dto.getText());
        audit.setType(dto.getType());

        return this.dao.save(audit);
    }

}
