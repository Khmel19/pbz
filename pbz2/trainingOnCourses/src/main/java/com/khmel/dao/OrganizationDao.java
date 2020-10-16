package com.khmel.dao;

import com.khmel.db.DB;
import com.khmel.model.Organization;
import com.khmel.model.Teacher;

import java.sql.*;
import java.util.List;

public class OrganizationDao implements GenericDao<Organization> {
    private Connection connection;

    public OrganizationDao() {
    }

    @Override
    public void create(Organization organization) {
        this.connection = DB.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO  "
                    + organization.getClass().getSimpleName().toLowerCase() +
                    "(id_course,name,address,telephone,email)" + " VALUES(?,?,?,?,?)");
            preparedStatement.setInt(1, organization.getIdCourse());
            preparedStatement.setString(2, organization.getName());
            preparedStatement.setString(3, organization.getAddress());
            preparedStatement.setString(4, organization.getTelephone());
            preparedStatement.setString(5, organization.getEmail());
            preparedStatement.execute();

            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Organization getFromPK(int key) {
        this.connection = DB.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Organization organization = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM " +
                    Organization.class.getSimpleName().toLowerCase() + " WHERE id=" + key);
            resultSet = preparedStatement.executeQuery();

            resultSet.next();
            organization = new Organization(resultSet.getInt(2), resultSet.getString(3),
                    resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return organization;
    }

    @Override
    public void update(Organization organization) {
        this.connection = DB.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("UPDATE " +
                    organization.getClass().getSimpleName().toLowerCase() + ""
                    + " SET id_course=?, name=?, address=?," +
                    " telephone=?, email=? WHERE id=" + organization.getId());
            try {

                preparedStatement.setInt(1, organization.getIdCourse());
                preparedStatement.setString(2, organization.getName());
                preparedStatement.setString(3, organization.getAddress());
                preparedStatement.setString(4, organization.getTelephone());
                preparedStatement.setString(5, organization.getEmail());
            } catch (SQLException e) {
                e.printStackTrace();
            }

            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(Organization organization) {
        this.connection = DB.getConnection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("DELETE FROM " +
                    organization.getClass().getSimpleName().toLowerCase() + ""
                    + " WHERE id=" + organization.getId());
            ps.execute();
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public ResultSet getAll() {
        this.connection = DB.getConnection();
        String sqlSelect = "SELECT * FROM organization";
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlSelect);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}

