package com.university.app.repositories;

import com.university.app.entity.Persona;
import org.springframework.data.jpa.repository.Query;

public interface ProfesorRepository extends PersonaRepository{

   // Iterable<Persona> findProfesoresByCarrera(String carrera);
}
