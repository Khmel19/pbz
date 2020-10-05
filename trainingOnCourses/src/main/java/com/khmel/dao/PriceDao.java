package com.khmel.dao;

import com.khmel.db.DB;
import com.khmel.model.Price;

import java.sql.Connection;
import java.util.List;

public class PriceDao implements GenericDao<Price>{
    private Connection connection;

    public PriceDao(DB bd) {
        this.connection = bd.getConnection();
    }

    @Override
    public Price create() {
        return null;
    }

    @Override
    public Price persist(Price object) {
        return null;
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
