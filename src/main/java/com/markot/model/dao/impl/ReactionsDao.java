package com.markot.model.dao.impl;

import com.markot.model.dao.AbstractGenericDao;
import com.markot.model.entity.Reactions;
import com.markot.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReactionsDao implements AbstractGenericDao<Reactions> {
    public static final String TABLE = "topolevsky.reactions";
    private static final String GET_ALL_QUERY = "SELECT * FROM topolevsky.reactions;";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + TABLE + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + TABLE + " (amount_of_views, amount_of_emojis) VALUES (?, ?);";

    private static final String UPDATE_QUERY = "UPDATE " + TABLE + " SET amount_of_views = ?, amount_of_emojis = ? WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + TABLE + " WHERE id = ?;";


    @Override
    public List<Reactions> findAll() {
        List<Reactions> reactions = new ArrayList<>();

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Reactions reaction = new Reactions(
                        resultSet.getInt("id"),
                        resultSet.getInt("amount_of_views"),
                        resultSet.getInt("amount_of_emojis")
                );
                reactions.add(reaction);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reactions;
    }


    @Override
    public Reactions findOne(Integer id) {
        Reactions reaction = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                reaction = new Reactions(
                        resultSet.getInt("id"),
                        resultSet.getInt("amount_of_views"),
                        resultSet.getInt("amount_of_emojis")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reaction;
    }

    @Override
    public void create(Reactions reaction) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setInt(1, Integer.valueOf(reaction.getAmountOfViews()));
            statement.setInt(2, Integer.valueOf(reaction.getAmountOfEmojis()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Integer id, Reactions reaction) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setInt(1, reaction.getAmountOfViews());
            statement.setInt(2, reaction.getAmountOfEmojis());
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