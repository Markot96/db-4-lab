package com.markot.model.entity;

import java.util.Objects;

public class StoryLine {
    private Integer userId;

    private String storyAuthor;

    private Integer watchedStatus;

    public StoryLine(Integer userId, String storyAuthor, Integer watchedStatus) {
        this.userId = userId;
        this.storyAuthor = storyAuthor;
        this.watchedStatus = watchedStatus;
    }

    public StoryLine(String storyAuthor, Integer watchedStatus) {
        this.storyAuthor = storyAuthor;
        this.watchedStatus = watchedStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoryLine storyLine = (StoryLine) o;
        return Objects.equals(userId, storyLine.userId) &&
                Objects.equals(storyAuthor, storyLine.storyAuthor) &&
                Objects.equals(watchedStatus, storyLine.watchedStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, storyAuthor, watchedStatus);
    }

    @Override
    public String toString() {
        return "\nStoryLine{" +
                "userId=" + userId +
                ", storyAuthor='" + storyAuthor + '\'' +
                ", watchedStatus=" + watchedStatus +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStoryAuthor() {
        return storyAuthor;
    }

    public void setStoryAuthor(String storyAuthor) {
        this.storyAuthor = storyAuthor;
    }

    public Integer getWatchedStatus() {
        return watchedStatus;
    }

    public void setWatchedStatus(Integer watchedStatus) {
        this.watchedStatus = watchedStatus;
    }
}
