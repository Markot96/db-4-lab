package com.markot.model.dao.impl;

import com.markot.model.dao.AbstractGenericDao;
import com.markot.model.entity.Avatar;
import com.markot.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AvatarDao implements AbstractGenericDao<Avatar> {
    public static final String TABLE = "topolevsky.avatar";
    private static final String GET_ALL_QUERY = "SELECT * FROM topolevsky.avatar;";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + TABLE + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + TABLE + " (file_name, file_size_in_mb) VALUES (?, ?);";

    private static final String UPDATE_QUERY = "UPDATE " + TABLE + " SET file_name = ?, file_size_in_mb = ? WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + TABLE + " WHERE id = ?;";


    @Override
    public List<Avatar> findAll() {
        List<Avatar> avatars = new ArrayList<>();

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Avatar avatar = new Avatar(
                        resultSet.getInt("id"),
                        resultSet.getString("file_name"),
                        resultSet.getFloat("file_size_in_mb")
                );
                avatars.add(avatar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return avatars;
    }


    @Override
    public Avatar findOne(Integer id) {
        Avatar avatar = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                avatar = new Avatar(
                        resultSet.getInt("id"),
                        resultSet.getString("file_name"),
                        resultSet.getFloat("file_size_in_mb")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return avatar;
    }

    @Override
    public void create(Avatar avatar) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, String.valueOf(avatar.getFileName()));
            statement.setFloat(2, Float.valueOf(avatar.getFileSizeInMb()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Integer id, Avatar avatar) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, avatar.getFileName());
            statement.setFloat(2, avatar.getFileSizeInMb());
            statement.setInt(3, id);
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