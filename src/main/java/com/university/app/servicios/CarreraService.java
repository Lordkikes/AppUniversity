package com.university.app.servicios;

import com.university.app.entity.Carrera;

import java.util.Optional;

public interface CarreraService {

    Optional<Carrera> findById(Integer id);
    Carrera save(Carrera carrera);
    Iterable<Carrera> findAll();
    void deleteById(Integer id);
}
