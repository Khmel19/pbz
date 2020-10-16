package com.khmel.dao;

import com.khmel.db.DB;
import com.khmel.model.Teacher;
import com.khmel.model.TeacherCourse;

import java.sql.*;
import java.util.List;

public class TeacherCourseDao implements GenericDao<TeacherCourse>{
    private Connection connection;

    public TeacherCourseDao() {

    }

    @Override
    public void create(TeacherCourse teacherCourse) {
        this.connection = DB.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO  "
                    + teacherCourse.getClass().getSimpleName().toLowerCase() +
                    "(id_teacher,id_course,start_date,end_date)"  + " VALUES(?,?,?,?)");
            preparedStatement.setInt(1, teacherCourse.getIdTeacher());
            preparedStatement.setInt(2, teacherCourse.getIdCourse());
            preparedStatement.setString(3, teacherCourse.getStartDate());
            preparedStatement.setString(4, teacherCourse.getEndDate());
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public TeacherCourse getFromPK(int key) {
        return null;
    }

    @Override
    public void update(TeacherCourse teacherCourse) {
        this.connection = DB.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("UPDATE " +
                    teacherCourse.getClass().getSimpleName().toLowerCase() + ""
                    + " SET id_teacher=?, id_course=?, start_date=?," +
                    " end_date=? WHERE id=" + teacherCourse.getIdTeacher());
            try {

                preparedStatement.setInt(1, teacherCourse.getIdTeacher());
                preparedStatement.setInt(2, teacherCourse.getIdCourse());
                preparedStatement.setString(3, teacherCourse.getStartDate());
                preparedStatement.setString(4, teacherCourse.getEndDate());

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
    public void delete(TeacherCourse teacherCourse) {
        this.connection = DB.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement=connection.prepareStatement("DELETE FROM "+teacherCourse.getClass().getSimpleName().toLowerCase()+
                    " WHERE id_teacher="+teacherCourse.getIdTeacher()+" AND id_course="+teacherCourse.getIdCourse());

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
        String sqlSelect = "SELECT * FROM teacher_course";
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
