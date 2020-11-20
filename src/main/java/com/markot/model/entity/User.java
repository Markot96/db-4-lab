package com.markot.model.entity;

import java.util.Objects;

public class User {
    private Integer id;

    private String nickName;

    private Integer avatarId;

    public User(Integer id, String nickName, Integer avatarId) {
        this.id = id;
        this.nickName = nickName;
        this.avatarId = avatarId;
    }

    public User(String nickName, Integer avatarId) {
        this.nickName = nickName;
        this.avatarId = avatarId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(nickName, user.nickName) &&
                Objects.equals(avatarId, user.avatarId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickName, avatarId);
    }


    @Override
    public String toString() {
        return "\nUser{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", avatarId=" + avatarId +
                '}';
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(Integer avatarId) {
        this.avatarId = avatarId;
    }
}
