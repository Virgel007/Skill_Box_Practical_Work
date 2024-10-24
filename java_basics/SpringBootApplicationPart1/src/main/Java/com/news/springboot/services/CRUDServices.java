package com.news.springboot.services;

import java.util.Collection;

public interface CRUDServices<T> {
    T getById(Long id);

    Collection<T> getAll();

    void create(T item);

    void update(Long id, T item);

    void delete(Long id);
}
