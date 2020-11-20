package com.markot.model.entity;

import java.util.Objects;

public class Password {

    private Integer id;

    private String password;

    private Integer userId;

    public Password(Integer id, String password, Integer userId) {
        this.id = id;
        this.password = password;
        this.userId = userId;
    }

    public Password(String password, Integer userId) {
        this.password = password;
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Password password1 = (Password) o;
        return Objects.equals(id, password1.id) &&
                Objects.equals(password, password1.password) &&
                Objects.equals(userId, password1.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password, userId);
    }

    @Override
    public String toString() {
        return "\nPassword{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", userId=" + userId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
