package by.mk_jd2_92_22.foodCounter.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PageDTO<T> implements IPageDTO<T>{

    private int number;
    private int size;
    @JsonProperty("total_pages")
    private int totalPages;
    @JsonProperty("total_element")
    private int totalElements;
    private boolean first;
    @JsonProperty("number_of_element")
    private int numberOfElements;
    private boolean last;
    private List<T> content;

    public PageDTO() {
    }

    public PageDTO(int number,
                   int size,
                   int totalPages,
                   int totalElements,
                   boolean first,
                   int number_of_elements,
                   boolean last,
                   List<T> content) {
        this.number = number;
        this.size = size;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.first = first;
        this.numberOfElements = number_of_elements;
        this.last = last;
        this.content = content;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public int getTotalPages() {
        return totalPages;
    }

    @Override
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    @Override
    public int getTotalElements() {
        return totalElements;
    }

    @Override
    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    @Override
    public boolean isFirst() {
        return first;
    }

    @Override
    public void setFirst(boolean first) {
        this.first = first;
    }

    @Override
    public int getNumberOfElements() {
        return numberOfElements;
    }

    @Override
    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    @Override
    public boolean isLast() {
        return last;
    }

    @Override
    public void setLast(boolean last) {
        this.last = last;
    }

    @Override
    public List<T> getContent() {
        return content;
    }

    @Override
    public void setContent(List<T> content) {
        this.content = content;
    }
}
