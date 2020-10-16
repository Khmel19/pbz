package com.khmel.dao;

import com.khmel.db.DB;
import com.khmel.model.Bid;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.List;

public class BidDao implements  GenericDao<Bid>{
    private Connection connection;

    public BidDao()  {
        this.connection = DB.getConnection();
    }
    
    @Override
    public void create(Bid bid) {
        this.connection = DB.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement=connection.prepareStatement("INSERT INTO "+
                    bid.getClass().getSimpleName().toLowerCase() + " (id_company,id_course,term,count_of_trainees)" +
                    " VALUES (?,?,?,?)");
            preparedStatement.setInt(1,bid.getIdCompany());
            preparedStatement.setInt(2,bid.getIdCourse());
            preparedStatement.setInt(3,bid.getTerm());
            preparedStatement.setInt(4,bid.getCountOfTrainees());

            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Bid getFromPK(int key) {
        this.connection = DB.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Bid bid=null;
        try {
            preparedStatement=connection.prepareStatement("SELECT * FROM "+
                    Bid.class.getSimpleName().toLowerCase() + " WHERE id="+key);
            resultSet=preparedStatement.executeQuery();

            resultSet.next();
            bid=new Bid(resultSet.getInt(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5));

            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bid;
    }

    @Override
    public void update(Bid bid) {
        this.connection = DB.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement=connection.prepareStatement("UPDATE bid SET id_company=?,id_course=?," +
                    "term=?,count_of_trainees=? WHERE id=" + bid.getId());
            preparedStatement.setInt(1,bid.getIdCompany());
            preparedStatement.setInt(2,bid.getIdCourse());
            preparedStatement.setInt(3,bid.getTerm());
            preparedStatement.setInt(4,bid.getCountOfTrainees());

            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(Bid bid) {
        this.connection = DB.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM " +
                    bid.getClass().getSimpleName().toLowerCase() + " WHERE id=" + bid.getId());

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
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlSelect);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return resultSet;
    }
}
