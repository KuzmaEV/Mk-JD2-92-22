package by.it_academy.jd2.Mk_JD2_92_22.pizza.core.dto;



import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {

    private LocalDateTime dtUpdate;
    private List<Selected> selectedItem;

    public OrderDTO() {
    }

    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }

    public void setDtUpdate(LocalDateTime dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    public List<Selected> getSelected() {
        return selectedItem;
    }

    public void setSelected(List<Selected> selectedItem) {
        this.selectedItem = selectedItem;
    }


    public static class Selected{
        private long menuRow;
        private int count;

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

}
