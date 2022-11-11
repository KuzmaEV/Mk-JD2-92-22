package by.it_academy.jd2.Mk_JD2_92_22.pizza.core.dto;


import java.time.LocalDateTime;

public class DtoMenuRowService {

    private LocalDateTime dtUpdate;
    private long info;
    private double price;
    private long menu;

    public DtoMenuRowService(LocalDateTime dtUpdate, long info, double price, long menu) {
        this.dtUpdate = dtUpdate;
        this.info = info;
        this.price = price;
        this.menu = menu;
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

    public long getMenu() {
        return menu;
    }

    public void setMenu(long menu) {
        this.menu = menu;
    }
}
