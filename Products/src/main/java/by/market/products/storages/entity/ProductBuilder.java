package by.market.products.storages.entity;

public class ProductBuilder {

    private Long id;
    private String name;
    private double price;
    private int sale;
    private String description;

    private ProductBuilder(){}

    public static ProductBuilder create(){
        return new ProductBuilder();
    }

    public ProductBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public ProductBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public ProductBuilder setSale(int sale) {
        this.sale = sale;
        return this;
    }

    public ProductBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public Product build(){
        return new Product(id, name, price, sale, description);
    }
}
