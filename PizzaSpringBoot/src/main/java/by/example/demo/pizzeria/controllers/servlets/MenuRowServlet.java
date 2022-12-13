package by.example.demo.pizzeria.controllers.servlets;

import by.example.demo.pizzeria.dao.entity.api.IMenuRow;
import by.example.demo.pizzeria.services.dto.MenuRowDTO;
import by.example.demo.pizzeria.services.api.IMenuRowService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping("/menu_row")
public class MenuRowServlet{

    private final IMenuRowService service;

    public MenuRowServlet(IMenuRowService service){
        this.service = service;
    }

    @GetMapping
    @RequestMapping("/{id}")
    protected ResponseEntity<IMenuRow> get(@PathVariable long id){

        return ResponseEntity.ok(service.read(id));
    }

    @GetMapping
    protected ResponseEntity<List<?extends IMenuRow>> getList(){

        return ResponseEntity.ok(service.get());
    }

    @PostMapping
    protected ResponseEntity<IMenuRow> doPost(@RequestBody MenuRowDTO dto){

        IMenuRow menuRow = service.create(dto);
        return new ResponseEntity<>(menuRow, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/dt_update/{dt_update}")
    protected ResponseEntity<IMenuRow> doPut(@PathVariable long id,
                                             @PathVariable("dt_update") long dtUpdateRow,
                                             @RequestBody MenuRowDTO dto){

        LocalDateTime dtUpdate = LocalDateTime.ofInstant(
                Instant.ofEpochMilli(dtUpdateRow),
                ZoneId.of("UTC")
        );

        return ResponseEntity.ok(service.update(id, dtUpdate, dto));


    }

    @DeleteMapping("/{id}/dt_update/{dt_update}")
    protected ResponseEntity<?> doDelete(@PathVariable long id,
                                         @PathVariable("dt_update") long dtUpdateRow){

        LocalDateTime dtUpdate = LocalDateTime.ofInstant(
                Instant.ofEpochMilli(dtUpdateRow),
                ZoneId.of("UTC")
        );
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
