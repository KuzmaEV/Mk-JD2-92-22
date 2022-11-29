package by.it_academy.jd2.Mk_JD2_92_22.pizza.services.dto;

import java.time.LocalDateTime;

public class DtoSelectedItemService {

    private LocalDateTime dtUpdate;
    private long menuRow;
    private int count;

    public DtoSelectedItemService() {
    }

    public DtoSelectedItemService(LocalDateTime dtUpdate, long menuRow, int count) {
        this.dtUpdate = dtUpdate;
        this.menuRow = menuRow;
        this.count = count;
    }

    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }

    public void setDtUpdate(LocalDateTime dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    public long getMenuRow() {
        return menuRow;
    }

    public void setMenuRow(long menuRow) {
        this.menuRow = menuRow;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
