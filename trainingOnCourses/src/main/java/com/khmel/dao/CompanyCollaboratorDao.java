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
    public void update(CompanyCollaborator object) {

    }

    @Override
    public void delete(CompanyCollaborator object) {

    }

    @Override
    public ResultSet getAll() {
        return null;
    }
}
