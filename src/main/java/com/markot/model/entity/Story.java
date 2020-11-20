package com.markot.model.entity;

import java.util.Objects;

public class Story {

    private Integer id;

    private Integer typeOfStory;

    private String fileName;

    private String uploadTime;

    private Float fileSizeInMb;

    private Integer durationInSeconds;

    private Integer storyLineUserId;

    private Integer adressId;

    public Story(Integer typeOfStory, String fileName, String uploadTime, Float fileSizeInMb, Integer durationInSeconds,
                 Integer storyLineUserId, Integer adressId) {
        this.typeOfStory = typeOfStory;
        this.fileName = fileName;
        this.uploadTime = uploadTime;
        this.fileSizeInMb = fileSizeInMb;
        this.durationInSeconds = durationInSeconds;
        this.storyLineUserId = storyLineUserId;
        this.adressId = adressId;
    }

    public Story(Integer id, Integer typeOfStory, String fileName, String uploadTime, Float fileSizeInMb,
                 Integer durationInSeconds, Integer storyLineUserId, Integer adressId) {
        this.id = id;
        this.typeOfStory = typeOfStory;
        this.fileName = fileName;
        this.uploadTime = uploadTime;
        this.fileSizeInMb = fileSizeInMb;
        this.durationInSeconds = durationInSeconds;
        this.storyLineUserId = storyLineUserId;
        this.adressId = adressId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Story story = (Story) o;
        return Objects.equals(id, story.id) &&
                Objects.equals(typeOfStory, story.typeOfStory) &&
                Objects.equals(fileName, story.fileName) &&
                Objects.equals(uploadTime, story.uploadTime) &&
                Objects.equals(fileSizeInMb, story.fileSizeInMb) &&
                Objects.equals(durationInSeconds, story.durationInSeconds) &&
                Objects.equals(storyLineUserId, story.storyLineUserId) &&
                Objects.equals(adressId, story.adressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeOfStory, fileName, uploadTime, fileSizeInMb, durationInSeconds, storyLineUserId, adressId);
    }

    @Override
    public String toString() {
        return "\nStory{" +
                "id=" + id +
                ", typeOfStory=" + typeOfStory +
                ", fileName='" + fileName + '\'' +
                ", uploadTime='" + uploadTime + '\'' +
                ", fileSizeInMb=" + fileSizeInMb +
                ", durationInSeconds=" + durationInSeconds +
                ", storyLineUserId=" + storyLineUserId +
                ", adressId=" + adressId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeOfStory() {
        return typeOfStory;
    }

    public void setTypeOfStory(Integer typeOfStory) {
        this.typeOfStory = typeOfStory;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Float getFileSizeInMb() {
        return fileSizeInMb;
    }

    public void setFileSizeInMb(Float fileSizeInMb) {
        this.fileSizeInMb = fileSizeInMb;
    }

    public Integer getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(Integer durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    public Integer getStoryLineUserId() {
        return storyLineUserId;
    }

    public void setStoryLineUserId(Integer storyLineUserId) {
        this.storyLineUserId = storyLineUserId;
    }

    public Integer getAdressId() {
        return adressId;
    }

    public void setAdressId(Integer adressId) {
        this.adressId = adressId;
    }
}
