package com.khmel.db;

import java.sql.*;

public class DB {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public DB(String url, String nameDB,String timeZone, String login, String password) {
        try {
            connection = DriverManager.getConnection(url+nameDB+timeZone,login, password);
            try{
                statement = connection.createStatement();
            }catch (SQLException e) {
                System.out.println("Ошибка при создании Statement "+ e);
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при создании Connection "+ e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }
}
