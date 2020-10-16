package com.khmel.dao;

import com.khmel.db.DB;
import com.khmel.model.Company;
import com.khmel.model.Course;
import com.khmel.model.Teacher;

import java.sql.*;
import java.util.List;

public class CompanyDao implements GenericDao<Company> {
    private Connection connection;

    public CompanyDao() {
        this.connection = DB.getConnection();
    }

    @Override
    public void create(Company company) {
        this.connection = DB.getConnection();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("INSERT INTO  "
                    + company.getClass().getSimpleName().toLowerCase() +
                    "(name,telephone,email,address)" + " VALUES(?,?,?,?)");
            preparedStatement.setString(1, company.getName());
            preparedStatement.setString(2, company.getTelephone());
            preparedStatement.setString(3, company.getEmail());
            preparedStatement.setString(4, company.getAddress());

            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Company getFromPK(int key) {
        this.connection = DB.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Company company = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM " +
                    Company.class.getSimpleName().toLowerCase() + " WHERE id=" + key);
            resultSet = preparedStatement.executeQuery();

            resultSet.next();
            company = new Company(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));

            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return company;
    }

    @Override
    public void update(Company company) {
        this.connection = DB.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("UPDATE company SET name=?, telephone=?," +
                    " email=?,address=? WHERE id=" + company.getId());
            preparedStatement.setString(1, company.getName());
            preparedStatement.setString(2, company.getTelephone());
            preparedStatement.setString(3, company.getEmail());
            preparedStatement.setString(4, company.getAddress());

            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(Company company) {
        this.connection = DB.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM " +
                    company.getClass().getSimpleName().toLowerCase() + " WHERE id=" + company.getId());
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
        String sqlSelect = "SELECT * FROM company";
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
