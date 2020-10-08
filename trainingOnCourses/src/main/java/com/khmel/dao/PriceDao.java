package com.khmel.dao;

import com.khmel.db.DB;
import com.khmel.model.Price;
import com.khmel.model.Teacher;

import java.sql.*;
import java.util.List;

public class PriceDao implements GenericDao<Price> {
    private Connection connection;

    public PriceDao() {
        this.connection = DB.getConnection();
    }

    @Override
    public void create(Price price) {
        this.connection = DB.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO " + price.getClass().getSimpleName().toLowerCase() +
                    "(price,date) VALUES(?,?)");
            preparedStatement.setInt(1, price.getPrice());
            preparedStatement.setString(2, price.getDate());

            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Price getFromPK(int key) {
        this.connection = DB.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Price price = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM " +
                    Price.class.getSimpleName().toLowerCase() + " WHERE id=" + price.getId());
            resultSet = preparedStatement.executeQuery();

            resultSet.next();

            price = new Price(resultSet.getInt(1), resultSet.getString(2));
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return price;
    }

    @Override
    public void update(Price price) {
        this.connection = DB.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("UPDATE price SET price=?,date=? WHERE id=" + price.getId());
            preparedStatement.setInt(1, price.getPrice());
            preparedStatement.setString(2, price.getDate());

            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(Price price) {
        this.connection = DB.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM " + price.getClass().getSimpleName().toLowerCase() +
                    " WHERE id=" + price.getId());

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
        String sqlSelect = "SELECT * FROM price";
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
