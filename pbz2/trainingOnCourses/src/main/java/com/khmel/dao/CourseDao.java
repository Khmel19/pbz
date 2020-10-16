package com.khmel.dao;

import com.khmel.db.DB;
import com.khmel.model.Course;
import com.khmel.model.Teacher;

import java.sql.*;
import java.util.List;

public class CourseDao implements GenericDao<Course> {
    private Connection connection;

    public CourseDao() {

    }

    @Override
    public void create(Course course) {
        this.connection = DB.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO  "
                    + course.getClass().getSimpleName().toLowerCase() +
                    "(name,type,count_of_days,count_of_trainees,id_price)" + " VALUES(?,?,?,?,?)");
            preparedStatement.setString(1, course.getName());
            preparedStatement.setString(2, course.getType());
            preparedStatement.setInt(3, course.getCountOfDays());
            preparedStatement.setInt(4, course.getCountOfTrainees());
            preparedStatement.setInt(5, course.getIdPrice());

            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public Course getFromPK(int key) {
        this.connection = DB.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Course course = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM " +
                    Course.class.getSimpleName().toLowerCase() + " WHERE id=" + key);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            course = new Course(resultSet.getString(2), resultSet.getString(3),
                    resultSet.getInt(4), resultSet.getInt(5), resultSet.getInt(6));
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return course;
    }

    @Override
    public void update(Course course) {
        this.connection = DB.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("UPDATE course SET name=?, type=?,"+
                    " count_of_days=?,count_of_trainees=?, id_price=? WHERE id=" + course.getId());
            try {

                preparedStatement.setString(1, course.getName());
                preparedStatement.setString(2, course.getType());
                preparedStatement.setInt(3, course.getCountOfDays());
                preparedStatement.setInt(4, course.getCountOfTrainees());
                preparedStatement.setInt(5, course.getIdPrice());
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
    public void delete(Course course) {
        this.connection = DB.getConnection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("DELETE FROM " +
                    course.getClass().getSimpleName().toLowerCase() + ""
                    + " WHERE id=" + course.getId());
            ps.execute();
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //SELECT course.id, name, type, count_of_days, count_of_trainees, price.price\n" +
    //                "FROM course JOIN price ON course.id_price = price.id
    @Override
    public ResultSet getAll() {
        this.connection = DB.getConnection();
        String sqlSelect = "SELECT * FROM course";
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
