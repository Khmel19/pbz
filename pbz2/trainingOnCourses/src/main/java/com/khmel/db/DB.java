package com.khmel.db;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {
    private static BufferedInputStream bis;
    private static Properties p;
    private static String url;
    private static String login;
    private static String password;
    private static String nameDB;
    private static String timeZone;
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static Connection getConnection() {
        try {
            bis = new BufferedInputStream(new FileInputStream("src/main/resources/db.properties"));
            p = new Properties();
            p.load(bis);
            url = (String) p.get("url");
            login = (String) p.get("login");
            password = (String) p.get("password");
            nameDB = (String) p.get("nameDb");
            timeZone = (String) p.get("timeZone");
            connection = DriverManager.getConnection(url + nameDB + timeZone, login, password);
            statement = connection.createStatement();
        } catch (SQLException | IOException ex){
            ex.printStackTrace();
        }
        return connection;
    }
    public static ResultSet query(String sql) throws SQLException {//select
        resultSet = statement.executeQuery(sql);
        return resultSet;
    }
    public static void closeConnectionAndStatement() throws SQLException {
        connection.close();
        statement.close();
    }
    public static void showTable(ResultSet rs) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();

        //выводим на консоль шапку таблицы
        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            System.out.print(rsmd.getColumnName(i) + "\t");
        }
        System.out.println();

        //выводим на консоль саму таблицу
        while (rs.next() == true) {
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println();
        }

    }
}
