package com.khmel.dao;

import com.khmel.db.DB;
import com.khmel.model.Course;

import java.sql.Connection;
import java.util.List;

public class CourseDao implements GenericDao<Course>{
    private Connection connection;

    public CourseDao(Connection connection) {
        this.connection = DB.getConnection();
    }

    @Override
    public void create() {

    }

    @Override
    public Course getFromPK(int key) {
        return null;
    }

    @Override
    public int update(Course object) {
        return 0;
    }

    @Override
    public int delete(Course object) {
        return 0;
    }

    @Override
    public List<Course> getAll() {
        return null;
    }
}
