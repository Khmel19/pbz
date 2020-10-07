package com.khmel.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface GenericDao<T>{
    public void create(T object) throws SQLException;
    public T getFromPK(int key);
    public void update(T object);
    public void delete(T object);
    public ResultSet getAll();
}
