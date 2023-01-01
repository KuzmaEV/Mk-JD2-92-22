package by.mk_jd2_92_22.auditservice.controller;


import by.mk_jd2_92_22.auditservice.model.Audit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/audit")
public class AuditController {

    @GetMapping
    public ResponseEntity<List<Audit>> get(){
        return null;
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Audit> get(@PathVariable UUID uuid){
        return null;
    }
}
