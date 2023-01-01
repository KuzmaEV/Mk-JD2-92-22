package by.mk_jd2_92_22.auditservice.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class MyUserDTO {

    private UUID uuid;
    private LocalDateTime dtCreate;
    private LocalDateTime dtUpdate;
    private String mail;
    private String nick;
    private Role role;
    private Status status;
}
