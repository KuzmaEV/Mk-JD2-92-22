package by.it_academy.jd2.Mk_JD2_92_22.pizza.core.dto;

public class DtoSelectedItemServlet {

    private long row;
    private int count;

    public DtoSelectedItemServlet() {
    }

    public DtoSelectedItemServlet(long id, int count) {
        this.row = id;
        this.count = count;
    }

    public long getRow() {
        return row;
    }

    public void setRow(long row) {
        this.row = row;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
