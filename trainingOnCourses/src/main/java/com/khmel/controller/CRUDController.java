package com.khmel.controller;

import com.khmel.dao.GenericDao;
import com.khmel.dao.TeacherDao;
import com.khmel.db.DB;
import com.khmel.view.Table;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDController {
    private GenericDao dao;

    public GenericDao getDao() {
        return dao;
    }

    public void setDao(GenericDao dao) {
        this.dao = dao;
    }

    public  Table createTable(){
       // TeacherDao teacherDao = new TeacherDao();
        ResultSet resultSet = dao.getAll();
        Table table = new Table(resultSet);
        try {
            DB.closeConnectionAndStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return table;
    }
}
