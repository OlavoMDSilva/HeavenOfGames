package com.olavo.finalproject.common.entity;

import java.util.ArrayList;

public interface EntityDAOInterface<T> {
    public void register(T entity);

    public ArrayList<T> findAll();

    public void update(T entity);

    public void delete(T entity);
}
