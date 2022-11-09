package com.university.app.servicios;

import com.university.app.entity.Carrera;

import java.util.Optional;

public interface GenericService<E> {

    Optional<E> findById(Integer id);
    E save(E entidad);
    Iterable<E> findAll();
    void deleteById(Integer id);
}
