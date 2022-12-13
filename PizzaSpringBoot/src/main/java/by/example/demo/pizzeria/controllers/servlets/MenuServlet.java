package by.example.demo.pizzeria.controllers.servlets;

import by.example.demo.pizzeria.dao.entity.api.IMenu;
import by.example.demo.pizzeria.services.api.IMenuService;
import by.example.demo.pizzeria.services.dto.MenuDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuServlet{

    private final IMenuService service;


    public MenuServlet(IMenuService service){
        this.service = service;
    }

    @GetMapping
    @RequestMapping("/{id}")
    protected ResponseEntity<IMenu> get(@PathVariable long id){

        return ResponseEntity.ok(service.read(id));
        }

    @GetMapping
    protected ResponseEntity<List<?extends IMenu>> getList(){

        return ResponseEntity.ok(service.get());
    }


    @PostMapping
    protected ResponseEntity<IMenu> doPost(@RequestBody MenuDTO dto){

        IMenu menu = service.create(dto);
        return new ResponseEntity<>(menu, HttpStatus.CREATED);

    }

    @PutMapping("/{id}/dt_update/{dt_update}")
    protected ResponseEntity<IMenu> doPut(@PathVariable long id,
                                          @PathVariable("dt_update") long dtUpdateRow,
                                          @RequestBody MenuDTO dto){

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

        service.delete(id, dtUpdate);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
