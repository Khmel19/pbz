package com.khmel.dao;

import com.khmel.db.DB;
import com.khmel.model.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TeacherDao implements GenericDao<Teacher>{
private Connection connection;

    public TeacherDao() {
        this.connection = DB.getConnection();
    }

    @Override
    public void create(Teacher teacher) throws SQLException {
        PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO  teacher VALUES(?,?,?,?)");
        preparedStatement.setString(1,teacher.getName());
        
    }

    @Override
    public Teacher getFromPK(int key) {
        return null;
    }

    @Override
    public int update(Teacher object) {
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
