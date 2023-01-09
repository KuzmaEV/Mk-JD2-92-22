package by.mk_jd2_92_22.auditservice.dto;


import by.mk_jd2_92_22.auditservice.model.MyUserDTO;
import by.mk_jd2_92_22.auditservice.model.Type;

public class AuditDTO {

    private MyUserDTO myUser;

    private String text;
    private Type type;

    private String id;

    public AuditDTO() {
    }

    public AuditDTO(MyUserDTO myUser, String text, Type type, String id) {
        this.myUser = myUser;
        this.text = text;
        this.type = type;
        this.id = id;
    }

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
