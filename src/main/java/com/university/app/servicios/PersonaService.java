package com.university.app.servicios;

import com.university.app.entity.Persona;

import java.util.Optional;

public interface PersonaService extends GenericService<Persona>{

    Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido);

    Optional<Persona> buscarPorDNI(String dni);

    Iterable<Persona> buscarPersonaPorApellido(String apellido);

}
