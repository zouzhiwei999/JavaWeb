package com.atguigu.pojo;

import java.math.BigDecimal;

/**
 * @author AOA
 * @version 1.0
 * @description: TODO
 * @date 2022/4/16 17:31
 */

public class Book {
    private String sn;
    private String name;
    private BigDecimal pricec;
    private String author;

    public Book() {
    }

    public Book(String sn, String name, BigDecimal pricec, String author) {
        this.sn = sn;
        this.name = name;
        this.pricec = pricec;
        this.author = author;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPricec() {
        return pricec;
    }

    public void setPricec(BigDecimal pricec) {
        this.pricec = pricec;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "sn='" + sn + '\'' +
                ", name='" + name + '\'' +
                ", pricec=" + pricec +
                ", author='" + author + '\'' +
                '}';
    }
}
