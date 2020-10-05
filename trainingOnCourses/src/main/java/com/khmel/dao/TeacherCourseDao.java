package com.khmel.dao;

import com.khmel.db.DB;
import com.khmel.model.TeacherCourse;

import java.util.List;

public class TeacherCourseDao implements GenericDao<TeacherCourse>{
    private DB bd;

    public TeacherCourseDao(DB bd) {
        this.bd = bd;
    }

    @Override
    public TeacherCourse create() {
        return null;
    }

    @Override
    public TeacherCourse persist(TeacherCourse object) {
        return null;
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
