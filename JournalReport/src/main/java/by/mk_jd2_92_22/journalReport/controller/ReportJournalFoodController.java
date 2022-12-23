package by.mk_jd2_92_22.journalReport.controller;

import by.mk_jd2_92_22.journalReport.dto.ReportJournalFoodDTO;
import by.mk_jd2_92_22.journalReport.model.ReportJournalFood;
import by.mk_jd2_92_22.journalReport.service.api.IReportJournalFoodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/report")
public class ReportJournalFoodController {

    private final IReportJournalFoodService service;

    public ReportJournalFoodController(IReportJournalFoodService report) {
        this.service = report;
    }

    @PostMapping("/{type}")
    ResponseEntity<?> create(@RequestBody ReportJournalFoodDTO dto){
        service.create(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<ReportJournalFood>> getAll(){
        return ResponseEntity.ok(service.getAll());}

    @GetMapping("/{uuid}/export")
    ResponseEntity<ReportJournalFood> get(@PathVariable UUID uuid){

        return ResponseEntity.ok(service.get(uuid));
    }

    @RequestMapping(method = RequestMethod.HEAD, value = "{uuid}/export")
    ResponseEntity<?> head(@PathVariable UUID uuid){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
