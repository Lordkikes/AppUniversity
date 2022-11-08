package com.university.app.servicios;

import com.university.app.entity.Persona;

import java.util.Optional;

public interface AlumnoService {

    Optional<Persona> findById(Integer id);
    Persona save(Persona persona);
    Iterable<Persona> findAll();
    void deleteById(Integer id);
}
