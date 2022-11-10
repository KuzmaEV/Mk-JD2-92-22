package by.it_academy.jd2.Mk_JD2_92_22.pizza.core.dto;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IPizzaInfo;

import java.time.LocalDateTime;

public class DtoMenuRowService {

    private LocalDateTime dtUpdate;
    private long info;
    private double price;

    public DtoMenuRowService(LocalDateTime dtUpdate, long info, double price) {
        this.dtUpdate = dtUpdate;
        this.info = info;
        this.price = price;
    }

    public void setDtUpdate(LocalDateTime dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    public void setInfo(long info) {
        this.info = info;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }

    public long getInfo() {
        return info;
    }

    public double getPrice() {
        return price;
    }
}
