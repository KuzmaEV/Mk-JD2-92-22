package by.it_academy.jd2.Mk_JD2_92_22.pizza.core.dto;

import java.time.LocalDateTime;

public class PizzaInfoDTO {

    private LocalDateTime dtUpdate;
    private String name;
    private String description;
    private int size;

    public PizzaInfoDTO() {
    }

    public PizzaInfoDTO(LocalDateTime dtUpdate, String name, String description, int size) {
        this.dtUpdate = dtUpdate;
        this.name = name;
        this.description = description;
        this.size = size;
    }

    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }

    public void setDtUpdate(LocalDateTime dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
