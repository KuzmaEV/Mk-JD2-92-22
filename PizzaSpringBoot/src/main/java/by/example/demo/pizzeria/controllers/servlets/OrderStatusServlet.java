package by.example.demo.pizzeria.controllers.servlets;

import by.example.demo.pizzeria.dao.entity.api.IOrderStatus;
import by.example.demo.pizzeria.services.api.IOrderStatusService;
import by.example.demo.pizzeria.services.dto.OrderStatusDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping("/order_status")
public class OrderStatusServlet {

    IOrderStatusService service;

    public OrderStatusServlet(IOrderStatusService service) {
        this.service = service;
    }

    @GetMapping
    @RequestMapping("/{id}")
    protected ResponseEntity<IOrderStatus> get(@PathVariable long id){

        return ResponseEntity.ok(service.read(id));
    }
    @GetMapping
    @RequestMapping("/ticket/{ticket}")
    protected ResponseEntity<IOrderStatus> getByTicket(@PathVariable long ticket){

        return ResponseEntity.ok(service.get(ticket));
    }

    @GetMapping
    protected ResponseEntity<List<?extends IOrderStatus>> getList(){

        return ResponseEntity.ok(service.get());
    }


    @PostMapping
    protected ResponseEntity<IOrderStatus> doPost(@RequestBody OrderStatusDTO dto){

        IOrderStatus menu = service.create(dto);
        return new ResponseEntity<>(menu, HttpStatus.CREATED);

    }

    @PutMapping("/{id}/dt_update/{dt_update}")
    protected ResponseEntity<IOrderStatus> doPut(@PathVariable long id,
                                          @PathVariable("dt_update") long dtUpdateRow,
                                          @RequestBody OrderStatusDTO dto){

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
