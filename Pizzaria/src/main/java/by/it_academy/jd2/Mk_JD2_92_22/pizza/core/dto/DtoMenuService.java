package by.it_academy.jd2.Mk_JD2_92_22.pizza.core.dto;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IMenuRow;

import java.time.LocalDateTime;
import java.util.List;

public class DtoMenuService {

    private final LocalDateTime dtUpdate;
    private final String name;
//    private final List<IMenuRow> items;
    private final boolean isEnabled;

    public DtoMenuService(LocalDateTime dtUpdate, String name, boolean isEnabled) {
        this.dtUpdate = dtUpdate;
        this.name = name;
        this.isEnabled = isEnabled;
    }



    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }

    public String getName() {
        return name;
    }

    public boolean isEnabled() {
        return isEnabled;
    }
}
