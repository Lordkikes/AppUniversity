package com.university.app.repositories;

import com.university.app.entity.Carrera;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CarreraRepository extends CrudRepository<Carrera, Integer> {

    //@Query("select c from Carrera c where c.nombreCarrera like %?1%")
    Iterable<Carrera> findCarrerasByNombreContains(String nombre);

    //@Query("select c from Carrera c where upper(c.nombreCarrera)like upper(%?1%)")
    Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);

    //@Query("select c from Carrera c where c.cantidadAnios > ?1")
    Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios);

    Iterable<Carrera> buscarCarrerasPorProfesorNombreYApellido(String nombre, String apellido);

}
