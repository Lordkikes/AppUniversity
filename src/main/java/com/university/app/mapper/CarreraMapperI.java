package com.university.app.mapper;

import com.university.app.dto.CarreraDTO;
import com.university.app.entity.Carrera;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CarreraMapperI {

    @Mappings({
            @Mapping(source = "id", target = "codigo")
    })
    CarreraDTO mapCarrera(Carrera carrera);

}
