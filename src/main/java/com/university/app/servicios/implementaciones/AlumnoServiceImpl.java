package com.university.app.servicios.implementaciones;

import com.university.app.entity.Persona;
import com.university.app.repositories.AlumnoRepository;
import com.university.app.repositories.PersonaRepository;
import com.university.app.servicios.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlumnoServiceImpl extends PersonaServiceImpl implements AlumnoService {

    @Autowired
    public AlumnoServiceImpl(@Qualifier("repositorioAlumnos")PersonaRepository repositroy) {
        super(repositroy);
    }

    @Override
    @Transactional(readOnly =true)
    public Iterable<Persona> buscarAlumnosPorNombreCarrera(String nombre) {
        return ((AlumnoRepository)repositroy).buscarAlumnosPorNombreCarrera(nombre);
    }
}
