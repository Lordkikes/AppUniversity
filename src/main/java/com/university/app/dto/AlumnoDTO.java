package com.university.app.dto;

import com.university.app.entity.Direccion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AlumnoDTO extends PersonaDTO{

    public AlumnoDTO(Integer id, String nombre, String apellido, String dni, Direccion direccion) {
        super(id, nombre, apellido, dni, direccion);
    }
}
