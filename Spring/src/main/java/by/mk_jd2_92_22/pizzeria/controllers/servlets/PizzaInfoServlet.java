package by.mk_jd2_92_22.pizzeria.controllers.servlets;

import by.mk_jd2_92_22.pizzeria.dao.entity.api.IPizzaInfo;
import by.mk_jd2_92_22.pizzeria.services.api.IPizzaInfoService;
import by.mk_jd2_92_22.pizzeria.services.dto.PizzaInfoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping("/pizza_info")
public class PizzaInfoServlet{

    private final IPizzaInfoService service;


    public PizzaInfoServlet(IPizzaInfoService service) {
        this.service = service;

    }

    //Read
    @GetMapping
    @RequestMapping("/{id}")
    protected ResponseEntity<IPizzaInfo> get(@PathVariable long id){

        return ResponseEntity.ok(service.read(id));
        }

        //Read List
    @GetMapping
    protected ResponseEntity<List<?extends IPizzaInfo>> getList(){

        return ResponseEntity.ok(service.get());
    }


    //Create
    @PostMapping
    protected ResponseEntity<IPizzaInfo> doPost(@RequestBody PizzaInfoDTO dto){

        IPizzaInfo pizzaInfo = service.create(dto);
        return new ResponseEntity<>(pizzaInfo, HttpStatus.CREATED);
    }

    //UPDATE
    @PutMapping("/{id}/dt_update/{dt_update}")
    protected ResponseEntity<IPizzaInfo> doPut(@PathVariable long id,
                                               @PathVariable ("dt_update") long dtUpdateRow,
                                               @RequestBody PizzaInfoDTO dto){

        LocalDateTime dtUpdate = LocalDateTime.ofInstant(
                Instant.ofEpochMilli(dtUpdateRow),
                ZoneId.of("UTC")
        );

        return ResponseEntity.ok(service.update(id, dtUpdate, dto));

    }

    //DELETE
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
