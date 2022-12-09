package by.mk_jd2_92_22.pizzeria.controllers.servlets;

import by.mk_jd2_92_22.pizzeria.dao.entity.api.IOrder;
import by.mk_jd2_92_22.pizzeria.services.api.IOrderService;
import by.mk_jd2_92_22.pizzeria.services.dto.OrderDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderServlet{
    
    private final IOrderService service;


    public OrderServlet(IOrderService service){
        this.service = service;
    }

    @GetMapping
    @RequestMapping("/{id}")
    protected ResponseEntity<IOrder> get(@PathVariable long id){

        return ResponseEntity.ok(service.read(id));
    }

    @GetMapping
    protected ResponseEntity<List<IOrder>> getList(){

        return ResponseEntity.ok(service.get());
    }


    @PostMapping
    protected ResponseEntity<IOrder> doPost(@RequestBody OrderDTO dto){

        IOrder menu = service.create(dto);
        return new ResponseEntity<>(menu, HttpStatus.CREATED);

    }

    @PutMapping("/{id}/dt_update/{dt_update}")
    protected ResponseEntity<IOrder> doPut(@PathVariable long id,
                                          @PathVariable("dt_update") long dtUpdateRow,
                                          @RequestBody OrderDTO dto){

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
