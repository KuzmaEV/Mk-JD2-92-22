package by.it_academy.jd2.Mk_JD2_92_22.pizza.services.dto;

public class DtoMenuServlet {

    private String name;
    private boolean isEnabled;

    public DtoMenuServlet() {
    }

    public DtoMenuServlet(String name, boolean isEnabled) {
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
