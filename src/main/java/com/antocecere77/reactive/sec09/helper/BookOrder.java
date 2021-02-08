package com.antocecere77.reactive.sec09.helper;

import com.antocecere77.reactive.courseutil.Util;
import com.github.javafaker.Book;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BookOrder {

    private String title;
    private String author;
    private String category;
    private double price;

    public BookOrder() {
        Book book = Util.faker().book();
        this.title = book.title();
        this.author = book.author();
        this.category = book.genre();
        this.price = Double.parseDouble(Util.faker().commerce().price().replaceAll(",", "."));
    }
}
