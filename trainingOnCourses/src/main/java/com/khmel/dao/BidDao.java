package com.khmel.dao;

import com.khmel.db.DB;
import com.khmel.model.Bid;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public class BidDao implements  GenericDao<Bid>{
    private Connection connection;

    public BidDao() throws FileNotFoundException {
        this.connection = DB.getConnection();
    }
    
    @Override
    public void create(Bid bid) {

    }

    @Override
    public Bid getFromPK(int key) {
        return null;
    }

    @Override
    public int update(Bid object) {
        return 0;
    }

    @Override
    public int delete(Bid object) {
        return 0;
    }

    @Override
    public ResultSet getAll() {
        return null;
    }
}
