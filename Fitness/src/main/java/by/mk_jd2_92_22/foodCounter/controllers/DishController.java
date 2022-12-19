package by.mk_jd2_92_22.foodCounter.controllers;

import by.mk_jd2_92_22.foodCounter.dao.entity.Dish;
import by.mk_jd2_92_22.foodCounter.services.DishService;
import by.mk_jd2_92_22.foodCounter.services.dto.DishDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/dish")
public class DishController {

    @Autowired
    private DishService service;

    @PostMapping
    ResponseEntity<Dish> create(@RequestBody DishDTO dto){
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping
    ResponseEntity<List<Dish>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping
    @RequestMapping("/{uuid}")
    ResponseEntity<Dish> get(@PathVariable UUID uuid){
        return ResponseEntity.ok(service.get(uuid));
    }

    @PutMapping("/{uuid}/dt_update/{dt_update}")
    ResponseEntity<Dish> update(@PathVariable UUID uuid,
                                   @PathVariable ("dt_update") long dtUpdateRow,
                                   @RequestBody DishDTO dto){

        LocalDateTime dtUpdate = LocalDateTime.ofInstant(
                Instant.ofEpochMilli(dtUpdateRow),
                ZoneId.of("UTC"));

        Dish product = service.update(uuid, dtUpdate, dto);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{uuid}/dt_update/{dt_update}")
    ResponseEntity<?> delete(@PathVariable UUID uuid,
                             @PathVariable ("dt_update") long dtUpdateRow){

        LocalDateTime dtUpdate = LocalDateTime.ofInstant(
                Instant.ofEpochMilli(dtUpdateRow),
                ZoneId.of("UTC"));
        service.delete(uuid, dtUpdate);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
