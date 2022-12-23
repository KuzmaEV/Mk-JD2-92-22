package by.mk_jd2_92_22.userSecurity.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class User {

    private UUID uuid;
    private LocalDateTime dtCreate;
    private LocalDateTime dtUpdate;
    private Status email;
    private Status nick;
    private Role role;
    private Status status;
}
