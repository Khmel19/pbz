package com.khmel.dao;

import com.khmel.db.DB;
import com.khmel.model.Collaborator;

import java.sql.*;
import java.util.List;

public class CollaboratorDao implements GenericDao<Collaborator> {
    private Connection connection;

    public CollaboratorDao() {
        this.connection = DB.getConnection();
    }

    @Override
    public void create(Collaborator collaborator) {
        this.connection = DB.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO " +
                    collaborator.getClass().getSimpleName().toLowerCase() + "(name,position,id_course)" +
                    "VALUES (?,?,?)");
            preparedStatement.setString(1, collaborator.getName());
            preparedStatement.setString(2, collaborator.getPosition());
            preparedStatement.setInt(3, collaborator.getIdCourse());

            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Collaborator getFromPK(int key) {
        this.connection = DB.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Collaborator collaborator = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM " +
                    Collaborator.class.getSimpleName().toLowerCase() + " WHERE id=" + key);
            resultSet = preparedStatement.executeQuery();

            resultSet.next();
            collaborator = new Collaborator(resultSet.getInt(4), resultSet.getString(2), resultSet.getString(3));

            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return collaborator;
    }

    @Override
    public void update(Collaborator collaborator) {
        this.connection = DB.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("UPDATE collaborator SET name=?, " +
                    "position=?, id_course=? WHERE id=" + collaborator.getId());
            preparedStatement.setString(1, collaborator.getName());
            preparedStatement.setString(2, collaborator.getPosition());
            preparedStatement.setInt(3, collaborator.getIdCourse());

            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void delete(Collaborator collaborator) {
        this.connection = DB.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM " +
                    collaborator.getClass().getSimpleName().toLowerCase() + " WHERE id=" + collaborator.getId());
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public ResultSet getAll() {
        this.connection = DB.getConnection();
        String sqlSelect = "SELECT * FROM collaborator";
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlSelect);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return resultSet;
    }
}
