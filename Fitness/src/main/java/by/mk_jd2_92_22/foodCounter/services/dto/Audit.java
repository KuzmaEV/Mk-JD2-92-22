package by.mk_jd2_92_22.foodCounter.services.dto;

import java.util.UUID;

public class Audit {

    private String id;
    private UUID user;
    private String text;
    private Type type;

    public Audit() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
