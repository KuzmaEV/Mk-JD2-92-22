package by.mk_jd2_92_22.auditservice.model;

import by.mk_jd2_92_22.auditservice.model.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Audit {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "user")
    private UUID user;
    @Column(name = "text")
    private String text;
    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private Type type;

    public Audit() {
    }

    public String getId() {
        return id;
    }

    public UUID getUser() {
        return user;
    }

    public void setUser(UUID user) {
        this.user = user;
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
}
