package by.mk_jd2_92_22.auditservice.service.api;

import by.mk_jd2_92_22.auditservice.dto.AuditRequestDTO;
import by.mk_jd2_92_22.auditservice.dto.PageDTO;
import by.mk_jd2_92_22.auditservice.model.Audit;

public interface IAuditService {
    PageDTO<Audit> get(int page, int size);
    Audit get(String id);
    Audit create(AuditRequestDTO dto);
}
