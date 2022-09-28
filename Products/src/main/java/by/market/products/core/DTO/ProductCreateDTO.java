package by.market.products.core.DTO;

public class ProductCreateDTO {

    private String name;
    private double price;
    private int sale;
    private String description;

    public ProductCreateDTO(String name, double price, int sale, String description) {
        this.name = name;
        this.price = price;
        this.sale = sale;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getSale() {
        return sale;
    }

    public String getDescription() {
        return description;
    }
}
