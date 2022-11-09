package com.university.app.servicios.implementaciones;

import com.university.app.entity.Persona;
import com.university.app.repositories.PersonaRepository;
import com.university.app.servicios.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AlumnoServiceImpl extends GenericServiceImpl<Persona, PersonaRepository> implements AlumnoService {

    @Autowired
    public AlumnoServiceImpl(@Qualifier("repositorioAlumnos")PersonaRepository repositroy) {
        super(repositroy);
    }
}
