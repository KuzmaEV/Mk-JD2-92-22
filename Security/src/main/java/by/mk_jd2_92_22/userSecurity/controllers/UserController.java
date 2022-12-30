package by.mk_jd2_92_22.userSecurity.controllers;

import by.mk_jd2_92_22.userSecurity.model.UserMe;
import by.mk_jd2_92_22.userSecurity.model.dto.AdminDTO;
import by.mk_jd2_92_22.userSecurity.services.api.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final IUserService service;

    public UserController(IUserService service) {
        this.service = service;
    }

    @PostMapping
    ResponseEntity<?> create(@RequestBody AdminDTO dto){
        service.create(dto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    @GetMapping
    ResponseEntity<List<UserMe>> getAll(){

        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{uuid}")
    ResponseEntity<UserMe> get(@PathVariable UUID uuid){

        return ResponseEntity.ok(service.get(uuid));
    }


    @PutMapping("/{uuid}/dt_update/{dt_update}")
    ResponseEntity<String> update(@RequestBody AdminDTO dto,
                                  @PathVariable UUID uuid,
                                  @PathVariable("dt_update") LocalDateTime dtUpdate){

        service.update(uuid, dtUpdate, dto);

        return ResponseEntity.ok().body("Счёт обновлён");
    }

}
