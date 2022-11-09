package com.university.app.repositories;

import com.university.app.entity.Persona;
import com.university.app.enumeradores.TipoEmpleado;

public interface EmpleadoRepository extends PersonaRepository{

    Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmpleado tipoEmpleado);
}
