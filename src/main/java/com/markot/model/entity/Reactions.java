package com.markot.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "reactions")
public class Reactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "amount_of_views")
    private Integer amountOfViews;

    @Column(name = "amount_of_emojis")
    private Integer amountOfEmojis;

    public Reactions(Integer id, Integer amountOfViews, Integer amountOfEmojis) {
        this.id = id;
        this.amountOfViews = amountOfViews;
        this.amountOfEmojis = amountOfEmojis;
    }

    public Reactions(Integer amountOfViews, Integer amountOfEmojis) {
        this.amountOfViews = amountOfViews;
        this.amountOfEmojis = amountOfEmojis;
    }

    public Reactions() {

    }

    @Override
    public String toString() {
        return "\nReactions{" +
                "id=" + id +
                ", amountOfViews=" + amountOfViews +
                ", amountOfEmojis=" + amountOfEmojis +
                "}";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmountOfViews() {
        return amountOfViews;
    }

    public void setAmountOfViews(Integer amountOfViews) {
        this.amountOfViews = amountOfViews;
    }

    public Integer getAmountOfEmojis() {
        return amountOfEmojis;
    }

    public void setAmountOfEmojis(Integer amountOfEmojis) {
        this.amountOfEmojis = amountOfEmojis;
    }
}