package com.university.app.dto;

import com.university.app.entity.Direccion;
import com.university.app.enumeradores.TipoEmpleado;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class EmpleadoDTO extends PersonaDTO{

    private BigDecimal sueldo;

    private TipoEmpleado tipoEmpleado;

    public EmpleadoDTO(Integer id, String nombre, String apellido,
                       String dni, Direccion direccion, BigDecimal sueldo,
                       TipoEmpleado tipoEmpleado) {
        super(id, nombre, apellido, dni, direccion);
        this.sueldo = sueldo;
        this.tipoEmpleado = tipoEmpleado;
    }
}
