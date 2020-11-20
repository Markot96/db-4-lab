package com.markot.model.entity;

import java.util.Objects;

public class Adress {
    private Integer id;

    private String color;

    public Adress(Integer id, String color) {
        this.id = id;
        this.color = color;
    }

    public Adress(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adress adress = (Adress) o;
        return Objects.equals(id, adress.id) &&
                Objects.equals(color, adress.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, color);
    }

    @Override
    public String toString() {
        return "\nAdress{" + "id=" + id + ", color='" + color + "}";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
