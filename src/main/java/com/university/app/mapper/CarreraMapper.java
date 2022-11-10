package com.university.app.mapper;

import com.university.app.dto.CarreraDTO;
import com.university.app.entity.Carrera;

public class CarreraMapper {

    public static CarreraDTO mapCarrera(Carrera carrera){
        CarreraDTO dto = new CarreraDTO();
        dto.setCodigo(carrera.getId());
        dto.setNombre(carrera.getNombre());
        dto.setCantidadAnios(carrera.getCantidadAnios());
        dto.setCantidadMaterias(carrera.getCantidadMaterias());
        return dto;
    }

}
