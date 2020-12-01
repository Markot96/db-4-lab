package com.markot.model.entity;

import javax.persistence.*;


@Table(name = "story")
@Entity
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "type_of_story")
    private Integer typeOfStory;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "upload_time")
    private String uploadTime;

    @Column(name = "file_size_in_mb")
    private Float fileSizeInMb;

    @Column(name = "duration_in_seconds")
    private Integer durationInSeconds;

    @Column(name = "comments_id")
    private Integer commentsId;

    @Column(name = "reactions_id")
    private Integer reactionsId;

    @ManyToOne
    @JoinColumn(name = "story_line_user_id", referencedColumnName = "user_id", nullable = false)
    private StoryLine storyLine;

    public Story(Integer id, Integer typeOfStory, String fileName, String uploadTime, Float fileSizeInMb, Integer durationInSeconds, StoryLine storyLine) {
        this.id = id;
        this.typeOfStory = typeOfStory;
        this.fileName = fileName;
        this.uploadTime = uploadTime;
        this.fileSizeInMb = fileSizeInMb;
        this.durationInSeconds = durationInSeconds;
        this.storyLine = storyLine;
    }

    public Story(Integer typeOfStory, String fileName, String uploadTime, Float fileSizeInMb, Integer durationInSeconds, StoryLine storyLine) {
        this.typeOfStory = typeOfStory;
        this.fileName = fileName;
        this.uploadTime = uploadTime;
        this.fileSizeInMb = fileSizeInMb;
        this.durationInSeconds = durationInSeconds;
        this.storyLine = storyLine;
    }

    public Story() {

    }

    public Story(int isPicture, String file_name, String upload_time, Float file_size_in_mb, Integer duration_in_seconds, Integer story_line_user_id) {
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

    public StoryLine getStoryLine() {
        return storyLine;
    }

    public void setStoryLine(StoryLine storyLine) {
        this.storyLine = storyLine;
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
                ", storyLine=" + storyLine +
                '}';
    }
}