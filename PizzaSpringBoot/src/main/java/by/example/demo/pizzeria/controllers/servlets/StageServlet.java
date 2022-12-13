package by.example.demo.pizzeria.controllers.servlets;

import by.example.demo.pizzeria.dao.entity.Stage;
import by.example.demo.pizzeria.services.api.IStageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping("/stage")
public class StageServlet {

    private final IStageService service;

    public StageServlet(IStageService service) {
        this.service = service;
    }

    @PostMapping
    protected ResponseEntity<Stage> doPost(@RequestBody String description){

        return ResponseEntity.ok(service.create(description));
    }

    @GetMapping
    protected ResponseEntity<List<Stage>> getList(){

        return ResponseEntity.ok(service.get());
    }

    @GetMapping
    @RequestMapping("/{id}")
    protected ResponseEntity<Stage> get(@PathVariable long id){

        return ResponseEntity.ok(service.read(id));

    }

    @PutMapping("/{id}/dt_update/{dt_update}")
    protected ResponseEntity<Stage> doPut(@PathVariable long id,
                                          @PathVariable ("dt_update") long dtUpdateRow,
                                          @RequestBody String description){

        LocalDateTime dtUpdate = LocalDateTime.ofInstant(
                Instant.ofEpochMilli(dtUpdateRow),
                ZoneId.of("UTC")
        );

        return ResponseEntity.ok(service.update(id, dtUpdate, description));
    }

    @DeleteMapping("/{id}/dt_update/{dt_update}")
    protected ResponseEntity<?> doDelete(@PathVariable long id,
                                         @PathVariable ("dt_update") long dtUpdateRow){

        LocalDateTime dtUpdate = LocalDateTime.ofInstant(
                Instant.ofEpochMilli(dtUpdateRow),
                ZoneId.of("UTC")
        );

        service.delete(id, dtUpdate);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
