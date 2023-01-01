package by.mk_jd2_92_22.auditservice.service.api;

import by.mk_jd2_92_22.auditservice.model.Audit;
import by.mk_jd2_92_22.auditservice.service.AudinService;

import java.util.List;
import java.util.UUID;

public interface IAuditService {
    List<Audit> get();
    Audit get(UUID uuid);
}
