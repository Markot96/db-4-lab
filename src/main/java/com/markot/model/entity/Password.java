package com.markot.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "password")
public class Password {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "password")
    private String password;

    @Column(name = "user_id")
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

    public Password() {

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

    @Override
    public String toString() {
        return "\nPassword{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
