package by.market.products.storages.entity;

public class Product {

    private Long id;
    private String name;
    private double price;
    private int sale;
    private String description;

    public Product() {
    }

    public Product(Long id, String name, double price, int sale, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sale = sale;
        this.description = description;
    }

    public Long getId() {
        return id;
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

    public void setId(Long id) {
        this.id = id;
    }
}
