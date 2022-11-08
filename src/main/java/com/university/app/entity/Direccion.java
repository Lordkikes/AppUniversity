package com.university.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Direccion implements Serializable {

    private String calle;

    private String numero;

    private String codigoPostal;

    private String dpto;

    private String piso;

    private String localidad;

}
