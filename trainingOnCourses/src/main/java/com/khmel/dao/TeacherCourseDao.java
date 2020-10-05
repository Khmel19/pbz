package com.khmel.dao;

import com.khmel.db.DB;
import com.khmel.model.TeacherCourse;

import java.sql.Connection;
import java.util.List;

public class TeacherCourseDao implements GenericDao<TeacherCourse>{
    private Connection connection;

    public TeacherCourseDao() {
        this.connection = DB.getConnection();
    }

    @Override
    public void create() {

    }

    @Override
    public TeacherCourse getFromPK(int key) {
        return null;
    }

    @Override
    public int update(TeacherCourse object) {
        return 0;
    }

    @Override
    public int delete(TeacherCourse object) {
        return 0;
    }

    @Override
    public List<TeacherCourse> getAll() {
        return null;
    }
}
