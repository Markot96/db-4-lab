package com.markot.model.entity;

import java.util.Objects;

public class Comments {
    private Integer id;

    private String author;

    private String text;

    private Integer amountOfLikes;

    private String writingTime;

    public Comments(Integer id, String author, String text, Integer amountOfLikes, String writingTime) {
        this.id = id;
        this.author = author;
        this.text = text;
        this.amountOfLikes = amountOfLikes;
        this.writingTime = writingTime;
    }

    public Comments(String author, String text, Integer amountOfLikes, String writingTime) {
        this.author = author;
        this.text = text;
        this.amountOfLikes = amountOfLikes;
        this.writingTime = writingTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comments comments = (Comments) o;
        return Objects.equals(id, comments.id) &&
                Objects.equals(author, comments.author) &&
                Objects.equals(text, comments.text) &&
                Objects.equals(amountOfLikes, comments.amountOfLikes) &&
                Objects.equals(writingTime, comments.writingTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, text, amountOfLikes, writingTime);
    }

    @Override
    public String toString() {
        return "\nComments{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", text='" + text + '\'' +
                ", amountOfLikes=" + amountOfLikes +
                ", writingTime=" + writingTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getAmountOfLikes() {
        return amountOfLikes;
    }

    public void setAmountOfLikes(Integer amountOfLikes) {
        this.amountOfLikes = amountOfLikes;
    }

    public String getWritingTime() {
        return writingTime;
    }

    public void setWritingTime(String writingTime) {
        this.writingTime = writingTime;
    }
}
