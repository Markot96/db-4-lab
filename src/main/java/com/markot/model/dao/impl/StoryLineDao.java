package com.markot.model.dao.impl;

import com.markot.model.dao.AbstractGenericDao;
import com.markot.model.entity.StoryLine;
import com.markot.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StoryLineDao implements AbstractGenericDao<StoryLine> {
    public static final String TABLE = "topolevsky.storyline";
    private static final String GET_ALL_QUERY = "SELECT * FROM topolevsky.storyline;";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + TABLE + " WHERE user_id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + TABLE + " (story_author, watched_status) " +
            "VALUES (?, ?);";

    private static final String UPDATE_QUERY = "UPDATE " + TABLE + " SET story_author = ?, watched_status = ?" +
            " WHERE user_id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + TABLE + " WHERE user_id = ?;";


    @Override
    public List<StoryLine> findAll() {
        List<StoryLine> storylines = new ArrayList<>();

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                StoryLine storyline = new StoryLine(
                        resultSet.getInt("user_id"),
                        resultSet.getString("story_author"),
                        resultSet.getInt("watched_status")
                );
                storylines.add(storyline);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return storylines;
    }


    @Override
    public StoryLine findOne(Integer user_id) {
        StoryLine storyline = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, user_id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                storyline = new StoryLine(
                        resultSet.getInt("user_id"),
                        resultSet.getString("story_author"),
                        resultSet.getInt("watched_status")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return storyline;
    }

    @Override
    public void create(StoryLine storyline) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, String.valueOf(storyline.getStoryAuthor()));
            statement.setInt(2, Integer.valueOf(storyline.getWatchedStatus()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Integer user_id, StoryLine storyline) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, storyline.getStoryAuthor());
            statement.setInt(2, storyline.getWatchedStatus());
            statement.setInt(3, user_id);
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Integer user_id) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, user_id);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}