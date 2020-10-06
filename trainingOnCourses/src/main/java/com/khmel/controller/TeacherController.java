package com.khmel.controller;

import com.khmel.dao.GenericDao;
import com.khmel.dao.TeacherDao;
import com.khmel.db.DB;
import com.khmel.view.Table;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherController {
    public static Table createTable(){
        TeacherDao teacherDao = new TeacherDao();
        ResultSet resultSet = teacherDao.getAll();
        Table teacherTable = new Table(resultSet);
        try {
            DB.closeConnectionAndStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacherTable;
    }
}
