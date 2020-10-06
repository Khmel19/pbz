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
    public int update(Company object) {
        return 0;
    }

    @Override
    public int delete(Company object) {
        return 0;
    }

    @Override
    public ResultSet getAll() {
        return null;
    }
}
