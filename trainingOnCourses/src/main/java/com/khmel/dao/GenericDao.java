package com.khmel.dao;

import java.util.List;

public interface GenericDao<T>{
    public T create();
    public T persist(T object);
    public T getFromPK(int key);
    public int update(T object);
    public int delete(T object);
    public List<T> getAll();
}
