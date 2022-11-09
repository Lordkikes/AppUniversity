package com.university.app.servicios;


import com.university.app.entity.Persona;

public interface AlumnoService extends PersonaService{

    Iterable<Persona> buscarAlumnosPorNombreCarrera(String nombre);

}
