package by.it_academy.jd2.Mk_JD2_92_22.pizza.core.dto;

public class DtoMenuRowServlet {

    private long info;
    private double price;

    public DtoMenuRowServlet() {
    }

    public DtoMenuRowServlet(long info, double price) {
        this.info = info;
        this.price = price;
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
}
