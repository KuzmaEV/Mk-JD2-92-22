package by.mk_jd2_92_22.pizzeria.services.dto;

import java.util.List;

public class OrderDTO {

    private List<Selected> selectedItem;

    public OrderDTO() {
    }

    public OrderDTO(List<Selected> selectedItem) {
        this.selectedItem = selectedItem;
    }

    public void setSelectedItem(List<Selected> selectedItem) {
        this.selectedItem = selectedItem;
    }

    public List<Selected> getSelectedItem() {
        return selectedItem;
    }

    public static class Selected{
        private long menuRow;
        private int count;

        public Selected(long menuRow, int count) {
            this.menuRow = menuRow;
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

}
