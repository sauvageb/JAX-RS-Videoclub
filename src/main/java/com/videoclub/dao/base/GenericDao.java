package com.videoclub.dao.base;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T, ID extends Number> {

    ID save(T object);

    List<T> findAll();

    Optional<T> findById(ID id);

    T update(T object);

    void delete(ID id);
}
