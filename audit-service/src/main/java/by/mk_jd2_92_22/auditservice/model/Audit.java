package by.mk_jd2_92_22.auditservice.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Audit {

    @ManyToOne
    private MyUserDTO myUser;

    @Column(name = "text")
    private String text;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "type")
    private Type type;

    @Id
    private UUID id;


    public MyUserDTO getMyUser() {
        return myUser;
    }

    public void setMyUser(MyUserDTO myUser) {
        this.myUser = myUser;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
