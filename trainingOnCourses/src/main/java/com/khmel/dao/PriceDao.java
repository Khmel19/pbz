package com.khmel.dao;

import com.khmel.db.DB;
import com.khmel.model.Price;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public class PriceDao implements GenericDao<Price>{
    private Connection connection;

    public PriceDao() {
        this.connection = DB.getConnection();
    }

    @Override
    public void create(Price price) {

    }

    @Override
    public Price getFromPK(int key) {
        return null;
    }

    @Override
    public void update(Price object) {

    }

    @Override
    public void delete(Price object) {

    }

    @Override
    public ResultSet getAll() {
        return null;
    }
}
