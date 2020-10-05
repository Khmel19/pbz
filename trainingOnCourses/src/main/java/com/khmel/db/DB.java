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

    public ResultSet query(String sql) throws SQLException {//select
        resultSet = statement.executeQuery(sql);
        return resultSet;
    }

    public void showTable(ResultSet rs) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();

        //выводим на консоль шапку таблицы
        for(int i = 1; i <= rsmd.getColumnCount(); i++) {
            System.out.print(rsmd.getColumnName(i) + "\t");
        }
        System.out.println();

        //выводим на консоль саму таблицу
        while(rs.next() == true) {
            for(int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println();
        }

    }

    public Connection getCn() {
        return connection;
    }
}
