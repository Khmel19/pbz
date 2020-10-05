package com.khmel.dao;

import java.util.List;

public interface GenericDao<T>{
    public void create();
    public T getFromPK(int key);
    public int update(T object);
    public int delete(T object);
    public List<T> getAll();
}
