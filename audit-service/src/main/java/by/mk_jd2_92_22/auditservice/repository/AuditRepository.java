package by.mk_jd2_92_22.auditservice.repository;

import by.mk_jd2_92_22.auditservice.model.Audit;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuditRepository extends JpaRepository<Audit, String> {
}
