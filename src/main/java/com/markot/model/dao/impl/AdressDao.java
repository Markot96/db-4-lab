package com.markot.model.dao.impl;

import com.markot.model.dao.AbstractGenericDao;
import com.markot.model.entity.Adress;
import com.markot.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdressDao implements AbstractGenericDao<Adress> {
    public static final String TABLE = "topolevsky.adress";
    private static final String GET_ALL_QUERY = "SELECT * FROM topolevsky.adress;";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + TABLE + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + TABLE + " (color) VALUES (?);";

    private static final String UPDATE_QUERY = "UPDATE " + TABLE + " SET color = ? WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + TABLE + " WHERE id = ?;";


    @Override
    public List<Adress> findAll() {
        List<Adress> adresses = new ArrayList<>();

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Adress adress = new Adress(
                        resultSet.getInt("id"),
                        resultSet.getString("color")
                );
                adresses.add(adress);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adresses;
    }


    @Override
    public Adress findOne(Integer id) {
        Adress adress = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                adress = new Adress(
                        resultSet.getInt("id"),
                        resultSet.getString("color")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adress;
    }

    @Override
    public void create(Adress adress) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, String.valueOf(adress.getColor()));
            statement.executeUpdate();
            System.out.println(statement);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }




    @Override
    public void update(Integer id, Adress adress) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, adress.getColor());
            statement.setInt(2, id);
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


