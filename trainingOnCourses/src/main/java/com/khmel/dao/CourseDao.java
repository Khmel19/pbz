package com.khmel.dao;

import com.khmel.db.DB;
import com.khmel.model.Course;

import java.util.List;

public class CourseDao implements GenericDao<Course>{
    private DB bd;

    public CourseDao(DB bd) {
        this.bd = bd;
    }

    @Override
    public Course create() {
        return null;
    }

    @Override
    public Course persist(Course object) {
        return null;
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
