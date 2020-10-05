package com.khmel.dao;

import com.khmel.db.DB;
import com.khmel.model.Collaborator;

import java.util.List;

public class CollaboratorDao implements GenericDao<Collaborator>{
    private DB bd;

    public CollaboratorDao(DB bd) {
        this.bd = bd;
    }

    @Override
    public Collaborator create() {
        return null;
    }

    @Override
    public Collaborator persist(Collaborator object) {
        return null;
    }

    @Override
    public Collaborator getFromPK(int key) {
        return null;
    }

    @Override
    public int update(Collaborator object) {
        return 0;
    }

    @Override
    public int delete(Collaborator object) {
        return 0;
    }

    @Override
    public List<Collaborator> getAll() {
        return null;
    }
}
