package com.khmel.dao;

import com.khmel.db.DB;
import com.khmel.model.Organization;

import java.util.List;

public class OrganizationDao implements GenericDao<Organization>{
    private DB bd;

    public OrganizationDao(DB bd) {
        this.bd = bd;
    }

    @Override
    public Organization create() {
        return null;
    }

    @Override
    public Organization persist(Organization object) {
        return null;
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
