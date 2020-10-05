package com.khmel.dao;

import com.khmel.db.DB;
import com.khmel.model.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TeacherDao implements GenericDao<Teacher> {
    private Connection connection;

    public TeacherDao() {
        this.connection = DB.getConnection();
    }

    @Override
    public void create(Teacher teacher) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO  teacher VALUES(?,?,?,?)");
        preparedStatement.setString(1, teacher.getName());

    }

    @Override
    public Teacher getFromPK(int key) {
        return null;
    }

    @Override
    public int update(Teacher teacher) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("UPDATE " +
                    teacher.getClass().getSimpleName().toLowerCase() + ""
                    + " SET name=?, birthday=?," +
                    " education=?, category=? WHERE id=" + teacher.getId());
            try {
                ps.setString(4, teacher.getCategory());
                ps.setString(1, teacher.getName());
                ps.setString(2, teacher.getBirthday());
                ps.setString(3, teacher.getEducation());
            } catch (SQLException e) {
                e.printStackTrace();
            }

            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(Teacher object) {
        return 0;
    }

    @Override
    public List<Teacher> getAll() {
        return null;
    }
}
