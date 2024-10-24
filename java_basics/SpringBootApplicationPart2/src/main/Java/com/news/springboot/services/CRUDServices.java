package com.news.springboot.services;

import java.util.Collection;

public interface CRUDServices<T> {
    T getById(Integer id);

    Collection<T> getAll();

    void create(T item);

    void update(Integer id, T item);

    void delete(Integer id);
}
