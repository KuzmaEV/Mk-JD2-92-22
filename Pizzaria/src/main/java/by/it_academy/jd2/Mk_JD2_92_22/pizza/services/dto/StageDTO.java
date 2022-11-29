package by.it_academy.jd2.Mk_JD2_92_22.pizza.services.dto;

import java.time.LocalDateTime;

public class StageDTO {

    private LocalDateTime dtUpdate;
    private String description;

    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }

    public void setDtUpdate(LocalDateTime dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
