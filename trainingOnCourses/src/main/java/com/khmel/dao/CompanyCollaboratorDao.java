package com.khmel.dao;

import com.khmel.db.DB;
import com.khmel.model.CompanyCollaborator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public class CompanyCollaboratorDao implements GenericDao<CompanyCollaborator>{
    private Connection connection;

    public CompanyCollaboratorDao() {
        this.connection = DB.getConnection();
    }

    @Override
    public void create(CompanyCollaborator companyCollaborator) {

    }

    @Override
    public CompanyCollaborator getFromPK(int key) {
        return null;
    }

    @Override
    public int update(CompanyCollaborator object) {
        return 0;
    }

    @Override
    public int delete(CompanyCollaborator object) {
        return 0;
    }

    @Override
    public ResultSet getAll() {
        return null;
    }
}
