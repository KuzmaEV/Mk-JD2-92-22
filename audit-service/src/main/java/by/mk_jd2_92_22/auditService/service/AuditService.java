package by.mk_jd2_92_22.auditService.service;

import by.mk_jd2_92_22.auditService.exception.NotFoundException;
import by.mk_jd2_92_22.auditService.dto.AuditRequestDTO;
import by.mk_jd2_92_22.auditService.dto.PageDTO;
import by.mk_jd2_92_22.auditService.model.UserAudit;
import by.mk_jd2_92_22.auditService.repository.AuditRepository;
import by.mk_jd2_92_22.auditService.model.Audit;
import by.mk_jd2_92_22.auditService.service.api.IAuditService;
import by.mk_jd2_92_22.auditService.service.api.IUserService;
import by.mk_jd2_92_22.auditService.service.mappers.MapperPageDTO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class AuditService implements IAuditService {

   private final AuditRepository dao;
   private final MapperPageDTO<Audit> mapperPage;
   private final IUserService userService;

    public AuditService(AuditRepository dao, MapperPageDTO<Audit> mapperPage, IUserService userService) {
        this.dao = dao;
        this.mapperPage = mapperPage;
        this.userService = userService;
    }


    @Override
    public PageDTO<Audit> get(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        return mapperPage.mapper(dao.findAll(pageable));
    }

    @Override
    public Audit get(String id) {

        return dao.findById(id).orElseThrow(() ->
                new NotFoundException("Аудит с таким id не найден"));
    }

    @Override
    @Transactional
    public Audit create(AuditRequestDTO dto) {

        final UserAudit userAudit = userService.create(dto.getUser());

        Audit audit = new Audit();
        audit.setUser(userAudit);
        audit.setText(dto.getText());
        audit.setType(dto.getType());

        return this.dao.save(audit);
    }

}
