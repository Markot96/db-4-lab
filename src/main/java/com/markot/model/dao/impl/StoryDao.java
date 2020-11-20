package com.markot.model.dao.impl;

import com.markot.model.dao.AbstractGenericDao;
import com.markot.model.entity.Story;
import com.markot.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StoryDao implements AbstractGenericDao<Story> {
    public static final String TABLE = "topolevsky.story";
    private static final String GET_ALL_QUERY = "SELECT * FROM topolevsky.story;";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + TABLE + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + TABLE + " (type_of_story, file_name, upload_time," +
            "file_size_in_mb, duration_in_seconds, story_line_user_id, adress_id ) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?);";

    private static final String UPDATE_QUERY = "UPDATE " + TABLE + " SET type_of_story = ?, file_name = ?, upload_time = ?," +
            "file_size_in_mb = ?, duration_in_seconds = ?, story_line_user_id = ?, adress_id = ? WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + TABLE + " WHERE id = ?;";


    @Override
    public List<Story> findAll() {
        List<Story> stories = new ArrayList<>();

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Story story = new Story(
                        resultSet.getInt("id"),
                        resultSet.getInt("type_of_story"),
                        resultSet.getString("file_name"),
                        resultSet.getString("upload_time"),
                        resultSet.getFloat("file_size_in_mb"),
                        resultSet.getInt("duration_in_seconds"),
                        resultSet.getInt("story_line_user_id"),
                        resultSet.getInt("adress_id")
                );
                stories.add(story);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stories;
    }


    @Override
    public Story findOne(Integer id) {
        Story story = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                story = new Story(
                        resultSet.getInt("id"),
                        resultSet.getInt("type_of_story"),
                        resultSet.getString("file_name"),
                        resultSet.getString("upload_time"),
                        resultSet.getFloat("file_size_in_mb"),
                        resultSet.getInt("duration_in_seconds"),
                        resultSet.getInt("story_line_user_id"),
                        resultSet.getInt("adress_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return story;
    }

    @Override
    public void create(Story story) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setInt(1, Integer.valueOf(story.getTypeOfStory()));
            statement.setString(2, String.valueOf(story.getFileName()));
            statement.setString(3, String.valueOf(story.getUploadTime()));
            statement.setFloat(4, Float.valueOf(story.getFileSizeInMb()));
            statement.setInt(5, Integer.valueOf(story.getDurationInSeconds()));
            statement.setInt(6, Integer.valueOf(story.getStoryLineUserId()));
            statement.setInt(7, Integer.valueOf(story.getAdressId()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Integer id, Story story) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setInt(1, story.getTypeOfStory());
            statement.setString(2, story.getFileName());
            statement.setString(3, story.getUploadTime());
            statement.setFloat(4, story.getFileSizeInMb());
            statement.setInt(5, story.getDurationInSeconds());
            statement.setInt(6, story.getStoryLineUserId());
            statement.setInt(7, story.getAdressId());
            statement.setInt(8, id);
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Integer id) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}