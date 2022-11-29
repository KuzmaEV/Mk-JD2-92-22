package by.it_academy.jd2.Mk_JD2_92_22.pizza.services.dto;

public class DtoMenuRowServlet {

    private long info;
    private double price;
    private long menu;

    public DtoMenuRowServlet() {
    }

    public DtoMenuRowServlet(long info, double price, long menu) {
        this.info = info;
        this.price = price;
        this.menu = menu;
    }

    public long getInfo() {
        return info;
    }

    public void setInfo(long info) {
        this.info = info;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getMenu() {
        return menu;
    }

    public void setMenu(long menu) {
        this.menu = menu;
    }
}
