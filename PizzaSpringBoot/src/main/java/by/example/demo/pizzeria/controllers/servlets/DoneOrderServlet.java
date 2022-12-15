package by.example.demo.pizzeria.controllers.servlets;


import by.example.demo.pizzeria.dao.entity.core.DoneOrder;
import by.example.demo.pizzeria.services.api.IDoneOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/done_order")
public class DoneOrderServlet {

    private final IDoneOrderService service;

    public DoneOrderServlet(IDoneOrderService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    ResponseEntity<DoneOrder> get(@PathVariable long id){
        return ResponseEntity.ok(service.get(id));
    }
}
