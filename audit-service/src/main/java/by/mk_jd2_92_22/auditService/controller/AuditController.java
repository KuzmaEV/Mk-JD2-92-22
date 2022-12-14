package by.mk_jd2_92_22.auditService.controller;

import by.mk_jd2_92_22.auditService.dto.AuditRequestDTO;
import by.mk_jd2_92_22.auditService.dto.PageDTO;
import by.mk_jd2_92_22.auditService.model.Audit;
import by.mk_jd2_92_22.auditService.service.api.IAuditService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/audit")
public class AuditController {

    private final IAuditService service;

    public AuditController(IAuditService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<PageDTO<Audit>> get(@RequestParam int page,
                                              @RequestParam int size){
        PageDTO<Audit> auditPageDTO = this.service.get(page, size);
        return ResponseEntity.ok(auditPageDTO);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Audit> get(@PathVariable String id){
        Audit audit = this.service.get(id);
        return ResponseEntity.ok(audit);
    }

    @PostMapping
    public ResponseEntity<Audit> create(@Valid @RequestBody AuditRequestDTO dto){

        Audit audit = this.service.create(dto);
        return ResponseEntity.ok(audit);
    }
}
