package by.mk_jd2_92_22.auditservice.dao;

import by.mk_jd2_92_22.auditservice.model.Audit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuditRepository extends JpaRepository<Audit, UUID> {
}
