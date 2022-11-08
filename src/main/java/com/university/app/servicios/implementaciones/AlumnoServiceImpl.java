package com.university.app.servicios.implementaciones;

import com.university.app.entity.Carrera;
import com.university.app.entity.Persona;
import com.university.app.repositories.PersonaRepository;
import com.university.app.servicios.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    @Qualifier("repositorioAlumnos")
    private PersonaRepository personaRepository;

    @Override
    @Transactional(readOnly =true)
    public Optional<Persona> findById(Integer id) {
        return personaRepository.findById(id);
    }

    @Override
    @Transactional
    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    @Transactional(readOnly =true)
    public Iterable<Persona> findAll() {
        return personaRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        personaRepository.deleteById(id);
    }

}
