package by.example.demo.pizzeria.services.dto;

public class StageDTO {

    private String description;
    private long orderStatus;

    public StageDTO() {
    }

    public StageDTO(String description, long orderStatus) {
        this.description = description;
        this.orderStatus = orderStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(long orderStatus) {
        this.orderStatus = orderStatus;
    }
}
