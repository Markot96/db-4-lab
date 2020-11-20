package com.markot.model.dao.impl;

import com.markot.model.dao.AbstractGenericDao;
import com.markot.model.entity.Password;
import com.markot.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PasswordDao implements AbstractGenericDao<Password> {
    public static final String TABLE = "topolevsky.password";
    private static final String GET_ALL_QUERY = "SELECT * FROM topolevsky.password;";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + TABLE + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + TABLE + " (password, user_id) VALUES (?, ?);";

    private static final String UPDATE_QUERY = "UPDATE " + TABLE + " SET password = ?, user_id = ? WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + TABLE + " WHERE id = ?;";


    @Override
    public List<Password> findAll() {
        List<Password> passwords = new ArrayList<>();

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Password password = new Password(
                        resultSet.getInt("id"),
                        resultSet.getString("password"),
                        resultSet.getInt("user_id")
                );
                passwords.add(password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return passwords;
    }


    @Override
    public Password findOne(Integer id) {
        Password avatar = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                avatar = new Password(
                        resultSet.getInt("id"),
                        resultSet.getString("password"),
                        resultSet.getInt("user_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return avatar;
    }

    @Override
    public void create(Password password) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, String.valueOf(password.getPassword()));
            statement.setInt(2, Integer.valueOf(password.getUserId()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Integer id, Password password) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, password.getPassword());
            statement.setFloat(2, password.getUserId());
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