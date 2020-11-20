package com.markot.model.entity;

import java.util.Objects;

public class Reactions {
    private Integer id;

    private Integer amountOfViews;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reactions reactions = (Reactions) o;
        return Objects.equals(id, reactions.id) &&
                Objects.equals(amountOfViews, reactions.amountOfViews) &&
                Objects.equals(amountOfEmojis, reactions.amountOfEmojis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amountOfViews, amountOfEmojis);
    }

    @Override
    public String toString() {
        return "\nReactions{" +
                "id=" + id +
                ", amountOfViews=" + amountOfViews +
                ", amountOfEmojis=" + amountOfEmojis +
                '}';
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
