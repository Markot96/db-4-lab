package com.markot.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "story_line")
public class StoryLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "story_author")
    private String storyAuthor;

    @Column(name = "watched_status")
    private Integer watchedStatus;

    @OneToMany(mappedBy = "storyLine", fetch = FetchType.EAGER)
    private Set<Story> story;

    public StoryLine(Integer id, String storyAuthor, Integer watchedStatus, Set<Story> story) {
        this.id = id;
        this.storyAuthor = storyAuthor;
        this.watchedStatus = watchedStatus;
        this.story = story;
    }

    public StoryLine(String storyAuthor, Integer watchedStatus, Set<Story> story) {
        this.storyAuthor = storyAuthor;
        this.watchedStatus = watchedStatus;
        this.story = story;
    }

    public StoryLine() {

    }

    public StoryLine(Integer id, String story_author, int isWatched) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Set<Story> getStory() {
        return story;
    }

    public void setStory(Set<Story> story) {
        this.story = story;
    }

    @Override
    public String toString() {
        return "\nStoryLine{" +
                "id=" + id +
                ", storyAuthor='" + storyAuthor + '\'' +
                ", watchedStatus=" + watchedStatus +
                ", story=" + story +
                '}';
    }
}