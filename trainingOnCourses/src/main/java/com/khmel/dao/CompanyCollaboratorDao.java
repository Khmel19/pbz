package com.khmel.dao;

import com.khmel.db.DB;
import com.khmel.model.CompanyCollaborator;

import java.util.List;

public class CompanyCollaboratorDao implements GenericDao<CompanyCollaborator>{
    private DB bd;

    public CompanyCollaboratorDao(DB bd) {
        this.bd = bd;
    }

    @Override
    public CompanyCollaborator create() {
        return null;
    }

    @Override
    public CompanyCollaborator persist(CompanyCollaborator object) {
        return null;
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
    public List<CompanyCollaborator> getAll() {
        return null;
    }
}
