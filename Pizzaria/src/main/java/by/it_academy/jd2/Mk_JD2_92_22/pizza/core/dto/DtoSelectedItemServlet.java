package by.it_academy.jd2.Mk_JD2_92_22.pizza.core.dto;

public class DtoSelectedItemServlet {

    private long menuRow;
    private int count;

    public DtoSelectedItemServlet() {
    }

    public DtoSelectedItemServlet(long id, int count) {
        this.menuRow = id;
        this.count = count;
    }

    public long getMenuRow() {
        return menuRow;
    }

    public void setMenuRow(long menuRow) {
        this.menuRow = menuRow;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
