package com.khmel.dao;

import com.khmel.db.DB;
import com.khmel.model.Company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public class CompanyDao implements GenericDao<Company>{
    private Connection connection;

    public CompanyDao() {
        this.connection = DB.getConnection();
    }

    @Override
    public void create(Company company) {

    }

    @Override
    public Company getFromPK(int key) {
        return null;
    }

    @Override
    public void update(Company object){
    }

    @Override
    public void delete(Company object) {

    }

    @Override
    public ResultSet getAll() {
        return null;
    }
}
