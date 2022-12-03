package by.mk_jd2_92_22.pizzeria.services.dto;

public class MenuDTO {

    private String name;
    private boolean isEnabled;

    public MenuDTO() {
    }

    public MenuDTO(String name, boolean isEnabled) {
        this.name = name;
        this.isEnabled = isEnabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }
}
