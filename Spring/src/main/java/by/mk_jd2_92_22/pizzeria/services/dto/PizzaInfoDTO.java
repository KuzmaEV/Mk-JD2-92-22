package by.mk_jd2_92_22.pizzeria.services.dto;


public class PizzaInfoDTO {

    private String name;
    private String description;
    private int size;

    public PizzaInfoDTO() {
    }

    public PizzaInfoDTO(String name, String description, int size) {

        this.name = name;
        this.description = description;
        this.size = size;
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
