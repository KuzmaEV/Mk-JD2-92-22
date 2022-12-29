package by.mk_jd2_92_22.userSecurity.controllers;

import by.mk_jd2_92_22.userSecurity.model.Role;
import by.mk_jd2_92_22.userSecurity.model.UserMe;
import by.mk_jd2_92_22.userSecurity.model.UserCreate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

//    private final IUserService service;
//
//    public UserController(IUserService service) {
//        this.service = service;
//    }

    @PostMapping
    ResponseEntity<?> create(@RequestBody UserCreate dto){
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    @GetMapping
    ResponseEntity<List<UserMe>> getAll(){

        List<UserMe> list = new ArrayList<>();
        UserMe user = new UserMe();
        user.setUuid(UUID.randomUUID());
        user.setNick("Yauheni");
        user.setMail("ya@ya.com");
        user.setRole(Role.USER);
        UserMe user2 = new UserMe();
        user.setNick("Kuzma");
        user.setMail("ku@zma.com");
        user.setRole(Role.ADMIN);

        list.add(user);
        list.add(user2);
        return ResponseEntity.ok(/*service.getAll()*/ list);
    }

    @GetMapping("/{uuid}")
    ResponseEntity<UserMe> get(@PathVariable UUID uuid){
        UserMe user = new UserMe();
        user.setNick("Yauheni");
        user.setMail("ya@ya.com");
        user.setRole(Role.USER);
        return ResponseEntity.ok(/*service.get(uuid)*/user);
    }


    @PutMapping("/{uuid}/dt_update/{dt_update}")
    ResponseEntity<UserMe> update(@RequestBody UserCreate dto,
                                  @PathVariable UUID uuid,
                                  @PathVariable("dt_update") LocalDateTime dtUpdate){

        UserMe user = new UserMe();
        user.setNick("Yauheni");
        user.setMail("ya@ya.com");
        user.setRole(Role.USER);
        return ResponseEntity.ok(/*service.update(uuid, dtUpdate, dto)*/user);
    }

}
