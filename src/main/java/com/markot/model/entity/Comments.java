package com.markot.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "author")
    private String author;

    @Column(name = "text")
    private String text;

    @Column(name = "amount_of_likes")
    private Integer amountOfLikes;

    @Column(name = "writing_time")
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

    public Comments() {

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

    @Override
    public String toString() {
        return "\nComments{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", text='" + text + '\'' +
                ", amountOfLikes=" + amountOfLikes +
                ", writingTime='" + writingTime + '\'' +
                '}';
    }
}
