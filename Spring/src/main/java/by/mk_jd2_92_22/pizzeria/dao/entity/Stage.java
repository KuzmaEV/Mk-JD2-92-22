package by.mk_jd2_92_22.pizzeria.dao.entity;

import by.mk_jd2_92_22.pizzeria.dao.entity.api.IStage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class Stage implements IStage {

    @Id
    private long id;
    @Column(name = "dt_create")
    private LocalDateTime dtCreate;

    @Version
    @Column(name = "dt_update")
    private LocalDateTime dtUpdate;

    private String description;
//    private LocalTime time;

    public Stage() {
    }

    public Stage(LocalDateTime dtCreate, LocalDateTime dtUpdate, String description) {
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.description = description;
    }

//    public void setTime(LocalTime time) {
//        this.time = time;
//    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public LocalDateTime getDtCreate() {
        return dtCreate;
    }

    @Override
    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

//    @Override
//    public LocalTime getTime() {
//        return this.time;
//    }

    @Override
    public void setDtUpdate(LocalDateTime dtUpdate) {
        this.dtUpdate = dtUpdate;
    }


    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Stage{" +
                "id=" + id +
                ", dtCreate=" + dtCreate +
                ", dtUpdate=" + dtUpdate +
                ", description='" + description + '\'' +
//                ", time=" + time +
                '}';
    }
}

