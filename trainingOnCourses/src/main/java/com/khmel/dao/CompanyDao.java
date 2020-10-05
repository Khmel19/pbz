package com.khmel.dao;

import com.khmel.db.DB;
import com.khmel.model.Company;

import java.util.List;

public class CompanyDao implements GenericDao<Company>{
    private DB bd;

    public CompanyDao(DB bd) {
        this.bd = bd;
    }

    @Override
    public Company create() {
        return null;
    }

    @Override
    public Company persist(Company object) {
        return null;
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
    public List<Company> getAll() {
        return null;
    }
}
