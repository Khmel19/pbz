package com.khmel.dao;

import com.khmel.db.DB;
import com.khmel.model.CompanyCollaborator;

import java.sql.*;
import java.util.List;

public class CompanyCollaboratorDao implements GenericDao<CompanyCollaborator> {
    private Connection connection;

    public CompanyCollaboratorDao() {
        this.connection = DB.getConnection();
    }

    @Override
    public void create(CompanyCollaborator companyCollaborator) {
        this.connection = DB.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO " +
                    companyCollaborator.getClass().getSimpleName().toLowerCase() +
                    "(id_collaborator,id_company) VALUES(?,?) ");
            preparedStatement.setInt(1, companyCollaborator.getIdCollaborator());
            preparedStatement.setInt(2, companyCollaborator.getIdCompany());

            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public CompanyCollaborator getFromPK(int key) {
        this.connection = DB.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        CompanyCollaborator companyCollaborator = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM " +
                    CompanyCollaborator.class.getSimpleName().toLowerCase() + " WHERE id=" + key);
            resultSet = preparedStatement.executeQuery();

            resultSet.next();
            companyCollaborator = new CompanyCollaborator(resultSet.getInt(2), resultSet.getInt(1));

            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return companyCollaborator;
    }

    @Override
    public void update(CompanyCollaborator companyCollaborator) {
        this.connection = DB.getConnection();
        PreparedStatement preparedStatement = null;
//        preparedStatement=connection.prepareStatement("UPDATE company_collaborator " +
//                "SET id_collaborator=?, id_company=? WHERE id="+companyCollaborator.)
    }

    @Override
    public void delete(CompanyCollaborator companyCollaborator) {
        this.connection = DB.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement=connection.prepareStatement("DELETE FROM "+
                    companyCollaborator.getClass().getSimpleName().toLowerCase()+
                     " WHERE id_company="+companyCollaborator.getIdCompany());
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
        String sqlSelect = "SELECT * FROM bid";
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sqlSelect);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
}
