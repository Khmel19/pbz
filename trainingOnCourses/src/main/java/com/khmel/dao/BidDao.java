package com.khmel.dao;

import com.khmel.db.DB;
import com.khmel.model.Bid;

import java.util.List;

public class BidDao implements  big<Bid>{
private DB bd;

    public BidDao(DB bd) {
        this.bd = bd;
    }


    @Override
    public Bid show() {
        return null;
    }

    @Override
    public Bid create() {
        return null;
    }

    @Override
    public Bid persist(Bid object) {
        return null;
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
    public List<Bid> getAll() {
        return null;
    }
}
