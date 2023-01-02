package by.mk_jd2_92_22.foodCounter.services.dto;

import java.util.List;

public interface IPageDTO<T> {

    int getNumber();

    void setNumber(int number);

    int getSize();

    void setSize(int size);

    int getTotalPages();

    void setTotalPages(int totalPages);

    int getTotalElements();

    void setTotalElements(int totalElements);

    boolean isFirst();

    void setFirst(boolean first);

    int getNumberOfElements();

    void setNumberOfElements(int numberOfElements);

    boolean isLast();

    void setLast(boolean last);

    List<T> getContent();

    void setContent(List<T> content);
}
