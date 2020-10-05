package com.khmel.dao;

import com.khmel.db.DB;
import com.khmel.model.Collaborator;

import java.sql.Connection;
import java.util.List;

public class CollaboratorDao implements GenericDao<Collaborator> {
    private Connection connection;

    public CollaboratorDao() {
        this.connection = DB.getConnection();
    }

    @Override
    public void create() {

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
