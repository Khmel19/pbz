package com.khmel.dao;

import com.khmel.db.DB;
import com.khmel.model.Teacher;

import java.util.List;

public class TeacherDao implements GenericDao<Teacher>{
    private DB bd;

    public TeacherDao(DB bd) {
        this.bd = bd;
    }

    @Override
    public void create() {

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
