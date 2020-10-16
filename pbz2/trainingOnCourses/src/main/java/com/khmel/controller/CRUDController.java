package com.khmel.controller;

import com.khmel.dao.GenericDao;
import com.khmel.dao.TeacherDao;
import com.khmel.db.DB;
import com.khmel.model.Model;
import com.khmel.model.Teacher;
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
    public Table insertIntoTable(Model model) {
        try {
            dao.create(model);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ResultSet resultSet = dao.getAll();
        Table table = new Table(resultSet);
        return table;
    }
    public Table updateTable(Model model){
        dao.update(model);
        ResultSet resultSet=dao.getAll();
        Table table=new Table(resultSet);
        return table;
    }
    public void deleteFromTable(Model model){
        dao.delete(model);
    }

    public Model getFromTable(int id){
        return (Model)dao.getFromPK(id);
    }
}
