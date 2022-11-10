package by.it_academy.jd2.Mk_JD2_92_22.pizza.core.dto;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IPizzaInfo;

import java.time.LocalDateTime;

public class DtoMenuRow {

    private LocalDateTime dtUpdate;
    private IPizzaInfo info;
    private double price;

    public DtoMenuRow(LocalDateTime dtUpdate, IPizzaInfo info, double price) {
        this.dtUpdate = dtUpdate;
        this.info = info;
        this.price = price;
    }

    public void setDtUpdate(LocalDateTime dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    public void setInfo(IPizzaInfo info) {
        this.info = info;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
