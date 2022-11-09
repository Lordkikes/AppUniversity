package com.university.app.servicios.implementaciones;

import com.university.app.entity.Persona;
import com.university.app.repositories.PersonaRepository;
import com.university.app.servicios.PersonaService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class PersonaServiceImpl extends GenericServiceImpl<Persona, PersonaRepository> implements PersonaService{


    public PersonaServiceImpl(PersonaRepository repositroy) {
        super(repositroy);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido) {
        return repositroy.buscarPorNombreYApellido(nombre, apellido);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> buscarPorDNI(String dni) {
        return repositroy.buscarPorDNI(dni);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> buscarPersonaPorApellido(String apellido) {
        return repositroy.buscarPersonaPorApellido(apellido);
    }
}
