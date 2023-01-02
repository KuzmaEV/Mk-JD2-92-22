package by.mk_jd2_92_22.foodCounter.controllers;

import by.mk_jd2_92_22.foodCounter.dao.entity.Product;
import by.mk_jd2_92_22.foodCounter.services.ProductService;
import by.mk_jd2_92_22.foodCounter.services.dto.PageDTO;
import by.mk_jd2_92_22.foodCounter.services.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    ResponseEntity<Product> create(@RequestBody ProductDTO dto){
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping
    ResponseEntity<PageDTO<Product>> get(@RequestParam int page,
                                @RequestParam int size){
        return ResponseEntity.ok(service.get(page, size));
    }

    @GetMapping
    @RequestMapping("/{uuid}")
    ResponseEntity<Product> get(@PathVariable UUID uuid){
        return ResponseEntity.ok(service.get(uuid));
    }


    @PutMapping("/{uuid}/dt_update/{dt_update}")
    ResponseEntity<Product> update(@PathVariable UUID uuid,
                                   @PathVariable ("dt_update") long dtUpdateRow,
                                   @RequestBody ProductDTO dto){

        LocalDateTime dtUpdate = LocalDateTime.ofInstant(
                Instant.ofEpochMilli(dtUpdateRow),
                ZoneId.of("UTC"));

        Product product = service.update(uuid, dtUpdate, dto);
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
