package com.udemy.person.data.vo;

import java.util.Date;
import java.util.Objects;

public class BookVO {
    private Long id;
    private String title;
    private String author;
    private Double price;
    private Date launchDate;

    public BookVO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookVO bookVO = (BookVO) o;
        return getId().equals(bookVO.getId()) && getTitle().equals(bookVO.getTitle()) && getAuthor().equals(bookVO.getAuthor()) && getPrice().equals(bookVO.getPrice()) && getLaunchDate().equals(bookVO.getLaunchDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getAuthor(), getPrice(), getLaunchDate());
    }
}
