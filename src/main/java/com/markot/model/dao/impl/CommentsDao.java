package com.markot.model.dao.impl;

import com.markot.model.dao.AbstractGenericDao;
import com.markot.model.entity.Comments;
import com.markot.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentsDao implements AbstractGenericDao<Comments> {
    public static final String TABLE = "topolevsky.comments";
    private static final String GET_ALL_QUERY = "SELECT * FROM topolevsky.comments;";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + TABLE + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + TABLE + " (author, text, amount_of_likes, writing_time) " +
            "VALUES (?, ?, ?, ?);";

    private static final String UPDATE_QUERY = "UPDATE " + TABLE + " SET author = ?, text = ?, amount_of_likes = ?, writing_time = ?" +
            " WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + TABLE + " WHERE id = ?;";


    @Override
    public List<Comments> findAll() {
        List<Comments> comments = new ArrayList<>();

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Comments comment = new Comments(
                        resultSet.getInt("id"),
                        resultSet.getString("author"),
                        resultSet.getString("text"),
                        resultSet.getInt("amount_of_likes"),
                        resultSet.getString("writing_time")
                );
                comments.add(comment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comments;
    }


    @Override
    public Comments findOne(Integer id) {
        Comments comment = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                comment = new Comments(
                        resultSet.getInt("id"),
                        resultSet.getString("author"),
                        resultSet.getString("text"),
                        resultSet.getInt("amount_of_likes"),
                        resultSet.getString("writing_time")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comment;
    }

    @Override
    public void create(Comments comment) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, String.valueOf(comment.getAuthor()));
            statement.setString(2, String.valueOf(comment.getText()));
            statement.setInt(3, Integer.valueOf(comment.getAmountOfLikes()));
            statement.setString(4, String.valueOf(comment.getWritingTime()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Integer id, Comments comment) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, comment.getAuthor());
            statement.setString(2, comment.getText());
            statement.setInt(3, comment.getAmountOfLikes());
            statement.setString(4, comment.getWritingTime());
            statement.setInt(5, id);
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