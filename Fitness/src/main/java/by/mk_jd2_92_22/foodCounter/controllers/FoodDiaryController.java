package by.mk_jd2_92_22.foodCounter.controllers;





import by.mk_jd2_92_22.foodCounter.dao.entity.FoodDiary;
import by.mk_jd2_92_22.foodCounter.services.FoodDiaryService;
import by.mk_jd2_92_22.foodCounter.services.dto.FoodDiaryDTO;
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
@RequestMapping("/food_diary")
public class FoodDiaryController {

    @Autowired
    private FoodDiaryService service;

    @PostMapping
    ResponseEntity<FoodDiary> create(@RequestBody FoodDiaryDTO dto){
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping
    ResponseEntity<List<FoodDiary>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping
    @RequestMapping("/{uuid}")
    ResponseEntity<FoodDiary> get(@PathVariable UUID uuid){
        return ResponseEntity.ok(service.get(uuid));
    }


    @PutMapping("/{uuid}/dt_update/{dt_update}")
    ResponseEntity<FoodDiary> update(@PathVariable UUID uuid,
                                   @PathVariable ("dt_update") long dtUpdateRow,
                                   @RequestBody FoodDiaryDTO dto){

        LocalDateTime dtUpdate = LocalDateTime.ofInstant(
                Instant.ofEpochMilli(dtUpdateRow),
                ZoneId.of("UTC"));

        FoodDiary product = service.update(uuid, dtUpdate, dto);
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
