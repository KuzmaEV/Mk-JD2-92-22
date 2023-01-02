package by.mk_jd2_92_22.foodCounter.controllers;

import by.mk_jd2_92_22.foodCounter.dao.entity.JournalFood;
import by.mk_jd2_92_22.foodCounter.services.JournalFoodService;
import by.mk_jd2_92_22.foodCounter.services.dto.JournalFoodDTO;
import by.mk_jd2_92_22.foodCounter.services.dto.PageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@RestController
@RequestMapping("/food")
public class JournalFoodController {

    @Autowired
    private JournalFoodService service;

    @PostMapping
    ResponseEntity<JournalFood> create(@RequestBody JournalFoodDTO dto){
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping
    ResponseEntity<PageDTO<JournalFood>> get(@RequestParam int page,
                                @RequestParam int size){
        return ResponseEntity.ok(service.get(page, size));
    }

    @GetMapping
    @RequestMapping("/{uuid}")
    ResponseEntity<JournalFood> get(@PathVariable UUID uuid){
        return ResponseEntity.ok(service.get(uuid));
    }


    @PutMapping("/{uuid}/dt_update/{dt_update}")
    ResponseEntity<JournalFood> update(@PathVariable UUID uuid,
                                       @PathVariable ("dt_update") long dtUpdateRow,
                                       @RequestBody JournalFoodDTO dto){

        LocalDateTime dtUpdate = LocalDateTime.ofInstant(
                Instant.ofEpochMilli(dtUpdateRow),
                ZoneId.of("UTC"));

        JournalFood product = service.update(uuid, dtUpdate, dto);
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
