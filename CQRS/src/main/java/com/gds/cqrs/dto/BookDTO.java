package com.gds.cqrs.dto;

import java.util.Objects;

/**
 * This is a DTO (Data Transfer Object) book, contains only useful information to be returned.
 */
public class BookDTO {

    private String title;
    private double price;

    /**
     * Constructor.
     *
     * @param title title of the book
     * @param price price of the book
     */
    public BookDTO(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public BookDTO() {
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price);
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BookDTO)) {
            return false;
        }
        BookDTO book = (BookDTO) obj;
        return title.equals(book.getTitle()) && price == book.getPrice();
    }

}
