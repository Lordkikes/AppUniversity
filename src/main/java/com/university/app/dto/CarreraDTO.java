package com.university.app.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarreraDTO {

    private Integer codigo;
    private String nombre;
    private Integer cantidadMaterias;
    private Integer cantidadAnios;

}
