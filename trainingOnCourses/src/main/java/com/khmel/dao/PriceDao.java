package com.khmel.dao;

import com.khmel.db.DB;
import com.khmel.model.Price;

import java.sql.Connection;
import java.util.List;

public class PriceDao implements GenericDao<Price>{
    private Connection connection;

    public PriceDao() {
        this.connection = DB.getConnection();
    }

    @Override
    public void create() {

    }

    @Override
    public Price getFromPK(int key) {
        return null;
    }

    @Override
    public int update(Price object) {
        return 0;
    }

    @Override
    public int delete(Price object) {
        return 0;
    }

    @Override
    public List<Price> getAll() {
        return null;
    }
}
