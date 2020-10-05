package com.khmel.dao;

import com.khmel.db.DB;
import com.khmel.model.Organization;

import java.sql.Connection;
import java.util.List;

public class OrganizationDao implements GenericDao<Organization>{
    private Connection connection;

    public OrganizationDao() {
        this.connection = DB.getConnection();
    }

    @Override
    public void create() {

    }

    @Override
    public Organization getFromPK(int key) {
        return null;
    }

    @Override
    public int update(Organization object) {
        return 0;
    }

    @Override
    public int delete(Organization object) {
        return 0;
    }

    @Override
    public List<Organization> getAll() {
        return null;
    }
}
